package com.neome.feature.form.presentation.form

import androidx.lifecycle.ViewModel
import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.ApiPlus
import com.neome.feature.form.presentation.ref.FormRef
import com.neome.feature.form.presentation.ref.FormRefImpl
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.form.presentation.state.FormEvent
import com.neome.feature.form.presentation.state.FormState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * ViewModel for dynamic form with full state management
 */
class FormViewModel : ViewModel() {

    private val _formState = MutableStateFlow(FormState())
    val formState = _formState.asStateFlow()

    val formRef: FormRef by lazy { FormRefImpl(this) }

    /**
     * Initialize form with DefnForm and optional initial value
     */
    fun initializeFromDefnForm(defnForm: DefnForm, formValueRaw: FormValueRaw? = null) {
        // Create initial FormValueRaw if not provided
        val initialValue = formValueRaw ?: createInitialFormValueRaw(defnForm)

        // Create fields map from DefnForm
        val fields = mutableMapOf<String, FieldState<*>>()
        defnForm.compMap.forEach { (compId, defnComp) ->
            val fieldId = defnComp.name.name
            val jsonValue = initialValue.valueMap[compId]
            val value = extractValueFromJson(jsonValue, defnComp.type.name)

            fields[fieldId] = FieldState(
                value = value,
                defaultValue = value,
                isRequired = false, // TODO: Get from DefnComp when available
                isDisabled = false,
                isTouched = false,
                isDirty = false
            )
        }

        _formState.update {
            it.copy(
                defnForm = defnForm,
                initialFormValue = initialValue,
                formValueRaw = initialValue,
                fields = fields,
                isDirty = false,
                isValid = true
            )
        }
    }

    /**
     * Handle form events
     */
    fun onEvent(event: FormEvent) {
        when (event) {
            is FormEvent.UpdateField<*> -> handleUpdateField(event)
            is FormEvent.SetValues -> handleSetValues(event.formValueRaw)
            is FormEvent.BlurField -> handleBlurField(event.fieldId)
            is FormEvent.Submit -> handleSubmit()
            is FormEvent.Reset -> handleReset(event.formValueRaw)
            is FormEvent.SetError -> handleSetError(event.fieldId, event.error)
            is FormEvent.ClearErrors -> handleClearErrors(event.fieldId)
        }
    }

    private fun handleUpdateField(event: FormEvent.UpdateField<*>) {
        val currentState = _formState.value
        val defnForm = currentState.defnForm ?: return

        // Find component ID
        val compId = defnForm.compMap.entries.find { entry ->
            entry.value.name.name == event.fieldId
        }?.key ?: return

        // Update FormValueRaw
        val updatedValueMap = currentState.formValueRaw?.valueMap?.toMutableMap() ?: mutableMapOf()
        updatedValueMap[compId] = convertValueToJson(event.value)

        val updatedFormValueRaw = FormValueRaw().apply {
            this.rowId = currentState.formValueRaw?.rowId ?: ApiPlus.nextRowId()
            this.valueMap = updatedValueMap
        }

        // Update FieldState
        val currentFieldState = currentState.fields[event.fieldId]
        val updatedFieldState = if (currentFieldState != null) {
            FieldState(
                value = event.value,
                defaultValue = currentFieldState.defaultValue,
                isRequired = currentFieldState.isRequired,
                isDisabled = currentFieldState.isDisabled,
                isTouched = currentFieldState.isTouched,
                isDirty = event.value != currentFieldState.defaultValue
            )
        } else {
            FieldState(
                value = event.value,
                defaultValue = event.value,
                isDirty = false
            )
        }

        val updatedFields = currentState.fields.toMutableMap()
        updatedFields[event.fieldId] = updatedFieldState

        _formState.update {
            it.copy(
                formValueRaw = updatedFormValueRaw,
                fields = updatedFields,
                isDirty = updatedFields.values.any { field -> field.isDirty }
            )
        }
    }

    private fun handleSetValues(formValueRaw: FormValueRaw) {
        val currentState = _formState.value
        val defnForm = currentState.defnForm ?: return

        // Update fields from FormValueRaw
        val updatedFields = mutableMapOf<String, FieldState<*>>()
        defnForm.compMap.forEach { (compId, defnComp) ->
            val fieldId = defnComp.name.name
            val jsonValue = formValueRaw.valueMap[compId]
            val value = extractValueFromJson(jsonValue, defnComp.type.name)

            val currentFieldState = currentState.fields[fieldId]
            val defaultValue = currentFieldState?.defaultValue ?: value

            updatedFields[fieldId] = FieldState(
                value = value,
                defaultValue = defaultValue,
                isRequired = false, // TODO: Get from DefnComp when available
                isDisabled = false,
                isTouched = true,
                isDirty = value != defaultValue
            )
        }

        _formState.update {
            it.copy(
                formValueRaw = formValueRaw,
                fields = updatedFields,
                isDirty = updatedFields.values.any { field -> field.isDirty }
            )
        }
    }

    private fun handleBlurField(fieldId: String) {
        val currentState = _formState.value
        val currentFieldState = currentState.fields[fieldId] ?: return

        val updatedFieldState = FieldState(
            value = currentFieldState.value,
            defaultValue = currentFieldState.defaultValue,
            isRequired = currentFieldState.isRequired,
            isDisabled = currentFieldState.isDisabled,
            isTouched = true,
            isDirty = currentFieldState.isDirty
        )

        val updatedFields = currentState.fields.toMutableMap()
        updatedFields[fieldId] = updatedFieldState

        _formState.update {
            it.copy(
                fields = updatedFields,
                touchedFields = it.touchedFields + fieldId
            )
        }
    }

    private fun handleSubmit() {
        _formState.update {
            it.copy(isSubmitting = true, submitError = null)
        }
    }

    private fun handleReset(formValueRaw: FormValueRaw?) {
        val currentState = _formState.value
        val resetValue = formValueRaw ?: currentState.initialFormValue ?: return

        handleSetValues(resetValue)

        _formState.update {
            it.copy(
                isDirty = false,
                errors = emptyMap(),
                touchedFields = emptySet()
            )
        }
    }

    private fun handleSetError(fieldId: String, error: String) {
        _formState.update {
            val updatedErrors = it.errors.toMutableMap()
            updatedErrors[fieldId] = error
            it.copy(errors = updatedErrors)
        }
    }

    private fun handleClearErrors(fieldId: String?) {
        _formState.update {
            if (fieldId != null) {
                val updatedErrors = it.errors.toMutableMap()
                updatedErrors.remove(fieldId)
                it.copy(errors = updatedErrors)
            } else {
                it.copy(errors = emptyMap())
            }
        }
    }

    /**
     * Create initial FormValueRaw with default values from DefnForm
     */
    private fun createInitialFormValueRaw(defnForm: DefnForm): FormValueRaw {
        val valueMap = mutableMapOf<com.neome.api.meta.base.Types.MetaIdComp, JsonElement>()

        defnForm.compMap.forEach { (compId, defnComp) ->
            val defaultValue = getDefaultValueForType(defnComp.type.name)
            valueMap[compId] = convertValueToJson(defaultValue)
        }

        return FormValueRaw().apply {
            this.rowId = ApiPlus.nextRowId()
            this.valueMap = valueMap
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
     * Extract value from JsonElement
     */
    private fun extractValueFromJson(jsonValue: JsonElement?, typeName: String): Any? {
        if (jsonValue == null || jsonValue.isJsonNull) {
            return getDefaultValueForType(typeName)
        }

        if (!jsonValue.isJsonPrimitive) return null

        val primitive = jsonValue.asJsonPrimitive
        return when (typeName.uppercase()) {
            "TEXT", "EMAIL", "PHONE", "URL", "PICK_TEXT" -> {
                if (primitive.isString) primitive.asString else ""
            }

            "NUMBER", "CURRENCY" -> {
                if (primitive.isNumber) primitive.asDouble else 0.0
            }

            "BOOL" -> {
                if (primitive.isBoolean) primitive.asBoolean else false
            }

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
