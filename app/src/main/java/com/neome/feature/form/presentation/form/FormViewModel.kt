package com.neome.feature.form.presentation.form

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.ApiPlus
import com.neome.feature.form.domain.validation.ValidationResult
import com.neome.feature.form.presentation.ref.FormRef
import com.neome.feature.form.presentation.ref.FormRefImpl
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.form.presentation.state.FormEffect
import com.neome.feature.form.presentation.state.FormEvent
import com.neome.feature.form.presentation.state.FormState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * ViewModel for dynamic form
 * Manages form state using MVI pattern
 */
class FormViewModel : ViewModel() {

    private val _formState = MutableStateFlow(FormState())
    val formState = _formState.asStateFlow()

    private val _effect = Channel<FormEffect>()
    val effect = _effect.receiveAsFlow()

    val formRef: FormRef by lazy { FormRefImpl(this) }

    private var currentDefnForm: DefnForm? = null

    /**
     * Initialize form from DefnForm and optional FormValueRaw
     */
    fun initializeFromDefnForm(defnForm: DefnForm, formValueRaw: FormValueRaw? = null) {
        currentDefnForm = defnForm
        val fields = mutableMapOf<String, FieldState<*>>()
        val valueMap = mutableMapOf<com.neome.api.meta.base.Types.MetaIdComp, JsonElement>()

        // Extract all fields from compMap
        defnForm.compMap.forEach { (compId, defnComp) ->
            val fieldId = defnComp.name.name

            // Get value from FormValueRaw or use default
            val jsonValue = formValueRaw?.valueMap?.get(compId)
            val value = extractValueFromJson(jsonValue, defnComp.type.name)

            // Store in valueMap for FormValueRaw
            valueMap[compId] = jsonValue ?: convertValueToJson(value)

            // Create field state
            fields[fieldId] = FieldState(
                value = value,
                defaultValue = value,
                isRequired = false,  // TODO: Extract from DefnComp
                isDisabled = defnComp.disabled ?: false,
                isTouched = false,
                isDirty = false,
                validationRules = emptyList()  // TODO: Add validation rules
            )
        }

        // Create or update FormValueRaw
        val updatedFormValueRaw = formValueRaw ?: FormValueRaw().apply {
            this.rowId = ApiPlus.nextRowId()
            this.valueMap = valueMap
        }

        // Update existing FormValueRaw if provided
        if (formValueRaw != null) {
            updatedFormValueRaw.valueMap = valueMap
        }

        _formState.update {
            it.copy(
                formValueRaw = updatedFormValueRaw,
                fields = fields,
                errors = emptyMap(),
                isDirty = false,
                isValid = true
            )
        }

        // Update FormRef watchers
        (formRef as? FormRefImpl)?.updateWatchers()
    }

    /**
     * Single entry point for all user actions
     */
    fun onEvent(event: FormEvent) {
        when (event) {
            is FormEvent.UpdateField<*> -> handleUpdateField(event)
            is FormEvent.SetValues -> handleSetValues(event.formValueRaw)
            is FormEvent.BlurField -> handleBlurField(event.fieldId)
            is FormEvent.ValidateField -> validateField(event.fieldId)
            is FormEvent.ValidateAll -> validateAllFields()
            is FormEvent.Submit -> submitForm()
            is FormEvent.Reset -> resetForm()
            is FormEvent.SetError -> setError(event.fieldId, event.error)
            is FormEvent.ClearErrors -> clearErrors(event.fieldId)
        }
    }

    private fun handleUpdateField(event: FormEvent.UpdateField<*>) {
        val fieldId = event.fieldId
        val newValue = event.value

        _formState.update { state ->
            val currentField = state.fields[fieldId]
            if (currentField != null) {
                @Suppress("UNCHECKED_CAST")
                val updatedField = (currentField as FieldState<Any?>).copy(
                    value = newValue,
                    isDirty = newValue != currentField.defaultValue,
                    isTouched = true
                )

                val updatedFields = state.fields.toMutableMap()
                updatedFields[fieldId] = updatedField

                // Update FormValueRaw
                val updatedFormValueRaw = state.formValueRaw?.let { formValueRaw ->
                    // Find the MetaIdComp for this field
                    val compId = currentDefnForm?.compMap?.entries?.find { entry ->
                        entry.value.name.name == fieldId
                    }?.key

                    if (compId != null) {
                        val updatedValueMap = formValueRaw.valueMap.toMutableMap()
                        updatedValueMap[compId] = convertValueToJson(newValue)

                        FormValueRaw().apply {
                            this.rowId = formValueRaw.rowId
                            this.valueMap = updatedValueMap
                            this.createdBy = formValueRaw.createdBy
                            this.createdOn = formValueRaw.createdOn
                            this.updatedBy = formValueRaw.updatedBy
                            this.updatedOn = formValueRaw.updatedOn
                            this.rowOrder = formValueRaw.rowOrder
                        }
                    } else {
                        formValueRaw
                    }
                }

                state.copy(
                    formValueRaw = updatedFormValueRaw,
                    fields = updatedFields,
                    isDirty = updatedFields.values.any { it.isDirty }
                )
            } else {
                state
            }
        }

        // Update FormRef watchers
        (formRef as? FormRefImpl)?.updateWatchers()

        // Re-validate dependent fields
        _formState.value.dependencies[fieldId]?.forEach { dependentField ->
            validateField(dependentField)
        }
    }

    private fun handleSetValues(formValueRaw: FormValueRaw) {
        val defnForm = currentDefnForm ?: return

        _formState.update { state ->
            val updatedFields = state.fields.toMutableMap()

            formValueRaw.valueMap.forEach { (compId, jsonValue) ->
                val defnComp = defnForm.compMap[compId] ?: return@forEach
                val fieldId = defnComp.name.name
                val value = extractValueFromJson(jsonValue, defnComp.type.name)

                val currentField = state.fields[fieldId]
                if (currentField != null) {
                    @Suppress("UNCHECKED_CAST")
                    val updatedField = (currentField as FieldState<Any?>).copy(
                        value = value,
                        isDirty = value != currentField.defaultValue,
                        isTouched = false
                    )
                    updatedFields[fieldId] = updatedField
                }
            }

            state.copy(
                formValueRaw = formValueRaw,
                fields = updatedFields,
                isDirty = updatedFields.values.any { it.isDirty }
            )
        }

        // Update FormRef watchers
        (formRef as? FormRefImpl)?.updateWatchers()
    }

    private fun handleBlurField(fieldId: String) {
        _formState.update { state ->
            val currentField = state.fields[fieldId]
            if (currentField != null) {
                @Suppress("UNCHECKED_CAST")
                val updatedField = (currentField as FieldState<Any?>).copy(isTouched = true)

                val updatedFields = state.fields.toMutableMap()
                updatedFields[fieldId] = updatedField

                state.copy(fields = updatedFields)
            } else {
                state
            }
        }

        validateField(fieldId)
    }

    private fun validateField(fieldId: String) {
        val field = _formState.value.fields[fieldId] ?: return

        val validationResults = field.validationRules.map { rule ->
            @Suppress("UNCHECKED_CAST")
            (rule as com.neome.feature.form.domain.validation.ValidationRule<Any?>).validate(
                field.value,
                _formState.value.fields
            )
        }

        val errorResult = validationResults.firstOrNull { it is ValidationResult.Error }
        val errorMessage = (errorResult as? ValidationResult.Error)?.message

        _formState.update { state ->
            val updatedErrors = state.errors.toMutableMap()
            if (errorMessage != null) {
                updatedErrors[fieldId] = errorMessage
            } else {
                updatedErrors.remove(fieldId)
            }

            state.copy(
                errors = updatedErrors,
                isValid = updatedErrors.isEmpty()
            )
        }
    }

    private fun validateAllFields() {
        _formState.value.fields.keys.forEach { fieldId ->
            validateField(fieldId)
        }
    }

    private fun submitForm() {
        validateAllFields()

        if (!_formState.value.isValid) {
            viewModelScope.launch {
                _effect.send(FormEffect.ShowError("Please fix all errors before submitting"))
            }
            return
        }

        viewModelScope.launch {
            _formState.update { it.copy(isSubmitting = true) }

            // TODO: Implement actual form submission
            // For now, just show success
            kotlinx.coroutines.delay(1000)

            _formState.update { it.copy(isSubmitting = false) }
            _effect.send(FormEffect.ShowSnackbar("Form submitted successfully"))
        }
    }

    private fun resetForm() {
        _formState.update { state ->
            val resetFields = state.fields.mapValues { (_, field) ->
                @Suppress("UNCHECKED_CAST")
                (field as FieldState<Any?>).copy(
                    value = field.defaultValue,
                    isDirty = false,
                    isTouched = false
                )
            }

            state.copy(
                fields = resetFields,
                errors = emptyMap(),
                isDirty = false,
                isValid = true,
                touchedFields = emptySet()
            )
        }

        (formRef as? FormRefImpl)?.updateWatchers()
    }

    private fun setError(fieldId: String, error: String) {
        _formState.update { state ->
            val updatedErrors = state.errors.toMutableMap()
            updatedErrors[fieldId] = error

            state.copy(
                errors = updatedErrors,
                isValid = false
            )
        }
    }

    private fun clearErrors(fieldId: String?) {
        _formState.update { state ->
            val updatedErrors = if (fieldId != null) {
                state.errors.toMutableMap().apply { remove(fieldId) }
            } else {
                emptyMap()
            }

            state.copy(
                errors = updatedErrors,
                isValid = updatedErrors.isEmpty()
            )
        }
    }

    /**
     * Extract value from JsonElement based on field type
     */
    private fun extractValueFromJson(jsonElement: JsonElement?, typeName: String): Any? {
        if (jsonElement == null || jsonElement.isJsonNull) return getDefaultValueForType(typeName)

        return when (typeName.uppercase()) {
            "TEXT", "EMAIL", "PHONE", "URL", "PICK_TEXT" -> {
                (jsonElement as? JsonPrimitive)?.asString ?: ""
            }

            "NUMBER", "CURRENCY" -> {
                (jsonElement as? JsonPrimitive)?.asDouble ?: 0.0
            }

            "BOOL" -> {
                (jsonElement as? JsonPrimitive)?.asBoolean ?: false
            }

            "DATE" -> {
                // TODO: Parse date from JSON
                null
            }

            else -> null
        }
    }

    /**
     * Get default value for field type
     */
    private fun getDefaultValueForType(typeName: String): Any? {
        return when (typeName.uppercase()) {
            "TEXT", "EMAIL", "PHONE", "URL", "PICK_TEXT" -> ""
            "NUMBER", "CURRENCY" -> 0.0
            "BOOL" -> false
            "DATE" -> null
            else -> null
        }
    }

    /**
     * Convert value to JsonElement
     */
    private fun convertValueToJson(value: Any?): JsonElement {
        return when (value) {
            is String -> JsonPrimitive(value)
            is Number -> JsonPrimitive(value)
            is Boolean -> JsonPrimitive(value)
            null -> com.google.gson.JsonNull.INSTANCE
            else -> JsonPrimitive(value.toString())
        }
    }
}
