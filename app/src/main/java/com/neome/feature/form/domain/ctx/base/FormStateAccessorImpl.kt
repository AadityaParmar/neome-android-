package com.neome.feature.form.domain.ctx.base

import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.feature.form.domain.ctx.FormStateAccessor
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldProperties
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.form.presentation.state.FormEventProps
import com.neome.feature.form.presentation.state.FormIntent
import com.neome.feature.form.presentation.state.FormState
import com.neome.feature.form.presentation.state.SendBtnStateFlag
import kotlinx.serialization.json.JsonElement

class ReducerFormStateAccessor(initialState: FormState) : FormStateAccessor {
    private var mutableState: MutableFormState = MutableFormState.fromImmutableState(initialState)
    private val baseState: FormState = initialState
    private val intents = mutableListOf<FormIntent>()

    // ==================== Read Methods ====================

    override fun getState(): FormState = mutableState.toImmutableState(baseState)

    override fun getValue(fieldId: MetaIdComp): JsonElement? = mutableState.valueMap[fieldId]

    override fun getFieldState(fieldId: MetaIdComp): FieldState? = mutableState.fieldStates[fieldId]

    override fun getError(fieldId: MetaIdComp): FieldError? = mutableState.errors[fieldId]

    override fun getValueMap(): Map<MetaIdComp, JsonElement> = mutableState.valueMap.toMap()

    override fun getFieldStates(): Map<MetaIdComp, FieldState> = mutableState.fieldStates.toMap()

    override fun getErrors(): Map<MetaIdComp, FieldError> = mutableState.errors.toMap()

    override fun getFieldProperties(fieldId: MetaIdComp): FieldProperties? =
        mutableState.fieldStates[fieldId]?.fieldProperties

    // ==================== Write Methods ====================

    override fun setValue(fieldId: MetaIdComp, value: JsonElement?) {
        if (value != null) {
            mutableState.valueMap[fieldId] = value
        } else {
            mutableState.valueMap.remove(fieldId)
        }
    }

    override fun removeValue(fieldId: MetaIdComp) {
        mutableState.valueMap.remove(fieldId)
    }

    override fun setFieldState(fieldId: MetaIdComp, fieldState: FieldState) {
        mutableState.fieldStates[fieldId] = fieldState
    }

    override fun updateFieldStates(fieldStates: Map<MetaIdComp, FieldState>) {
        mutableState.fieldStates.putAll(fieldStates)
    }

    override fun setError(fieldId: MetaIdComp, error: FieldError) {
        mutableState.errors[fieldId] = error
    }

    override fun clearError(fieldId: MetaIdComp) {
        mutableState.errors.remove(fieldId)
    }

    override fun updateErrors(errors: Map<MetaIdComp, FieldError>) {
        mutableState.errors.putAll(errors)
    }

    override fun clearAllErrors() {
        mutableState.errors.clear()
    }

    override fun setFormEventPropsMap(map: Map<MetaIdComp, FormEventProps>) {
        mutableState.formEventPropsMap = map
    }

    override fun setSendBtnStateFlags(flags: Set<SendBtnStateFlag>) {
        mutableState.sendBtnStateFlags.clear()
        mutableState.sendBtnStateFlags.addAll(flags)
    }

    override fun setIsSubmitting(value: Boolean) {
        mutableState.isSubmitting = value
    }

    override fun updateState(transform: (FormState) -> FormState) {
        val tempImmutable = mutableState.toImmutableState(baseState)
        val newImmutable = transform(tempImmutable)
        mutableState = MutableFormState.fromImmutableState(newImmutable)
    }

    // ==================== Intent ====================

    override fun emitIntent(intent: FormIntent) {
        intents.add(intent)
    }

    // ==================== Result ====================

    fun result(): FormReducerResult = FormReducerResult(
        state = mutableState.toImmutableState(baseState),
        intents = collectedIntents()
    )

    fun collectedIntents(): List<FormIntent> = intents.toList()
}


internal data class MutableFormState(
    val valueMap: MutableMap<MetaIdComp, JsonElement> = mutableMapOf(),
    val fieldStates: MutableMap<MetaIdComp, FieldState> = mutableMapOf(),
    val errors: MutableMap<MetaIdComp, FieldError> = mutableMapOf(),
    var formEventPropsMap: Map<MetaIdComp, FormEventProps> = emptyMap(),
    val sendBtnStateFlags: MutableSet<SendBtnStateFlag> = mutableSetOf(),
    var isSubmitting: Boolean = false,
    val disabled: Boolean = false,
    val readOnly: Boolean = false,
    val formError: String? = null,
    val isInitialized: Boolean = false
) {
    /**
     * Convert to immutable FormState for UI consumption.
     * Called only once per reducer cycle, avoiding repeated allocations.
     */
    fun toImmutableState(
        baseState: FormState
    ): FormState {
        return baseState.copy(
            valueMap = valueMap.toMap(),
            fieldStates = fieldStates.toMap(),
            errors = errors.toMap(),
            formEventPropsMap = formEventPropsMap,
            sendBtnStateFlags = sendBtnStateFlags.toSet(),
            isSubmitting = isSubmitting,
            disabled = disabled,
            readOnly = readOnly,
            formError = formError,
            isInitialized = isInitialized
        )
    }

    companion object {
        /**
         * Create mutable state from immutable FormState.
         * Called once at the start of each reducer cycle.
         */
        fun fromImmutableState(state: FormState): MutableFormState {
            return MutableFormState(
                valueMap = state.valueMap.toMutableMap(),
                fieldStates = state.fieldStates.toMutableMap(),
                errors = state.errors.toMutableMap(),
                formEventPropsMap = state.formEventPropsMap,
                sendBtnStateFlags = state.sendBtnStateFlags.toMutableSet(),
                isSubmitting = state.isSubmitting,
                disabled = state.disabled,
                readOnly = state.readOnly,
                formError = state.formError,
                isInitialized = state.isInitialized
            )
        }
    }
}
