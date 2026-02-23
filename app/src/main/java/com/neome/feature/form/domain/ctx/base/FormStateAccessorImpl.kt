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

/**
 * Accessor for reducer/processEvent context.
 * Wraps a mutable state variable — all reads see latest accumulated state,
 * all writes update via state.copy(). Collects intents in a list.
 *
 * Usage:
 * ```
 * val accessor = ReducerFormStateAccessor(currentState)
 * helper.handleSomething(accessor, event)
 * val result = accessor.result()
 * ```
 */
class ReducerFormStateAccessor(initialState: FormState) : FormStateAccessor {
    private var state = initialState
    private val intents = mutableListOf<FormIntent>()

    // ==================== Read Methods ====================

    override fun getState() = state

    override fun getValue(fieldId: MetaIdComp): JsonElement? = state.getValue(fieldId)

    override fun getFieldState(fieldId: MetaIdComp): FieldState? = state.getFieldState(fieldId)

    override fun getError(fieldId: MetaIdComp): FieldError? = state.getError(fieldId)

    override fun getValueMap(): Map<MetaIdComp, JsonElement> = state.valueMap

    override fun getFieldStates(): Map<MetaIdComp, FieldState> = state.fieldStates

    override fun getErrors(): Map<MetaIdComp, FieldError> = state.errors

    override fun getFieldProperties(fieldId: MetaIdComp): FieldProperties? =
        state.getFieldState(fieldId)?.fieldProperties

    // ==================== Write Methods ====================

    override fun setValue(fieldId: MetaIdComp, value: JsonElement?) {
        state = if (value != null) {
            state.copy(valueMap = state.valueMap + (fieldId to value))
        } else {
            state.copy(valueMap = state.valueMap - fieldId)
        }
    }

    override fun removeValue(fieldId: MetaIdComp) {
        state = state.copy(valueMap = state.valueMap - fieldId)
    }

    override fun setFieldState(fieldId: MetaIdComp, fieldState: FieldState) {
        state = state.copy(fieldStates = state.fieldStates + (fieldId to fieldState))
    }

    override fun updateFieldStates(fieldStates: Map<MetaIdComp, FieldState>) {
        state = state.copy(fieldStates = state.fieldStates + fieldStates)
    }

    override fun setError(fieldId: MetaIdComp, error: FieldError) {
        state = state.copy(errors = state.errors + (fieldId to error))
    }

    override fun clearError(fieldId: MetaIdComp) {
        state = state.copy(errors = state.errors - fieldId)
    }

    override fun updateErrors(errors: Map<MetaIdComp, FieldError>) {
        state = state.copy(errors = state.errors + errors)
    }

    override fun clearAllErrors() {
        state = state.copy(errors = emptyMap())
    }

    override fun setFormEventPropsMap(map: Map<MetaIdComp, FormEventProps>) {
        state = state.copy(formEventPropsMap = map)
    }

    override fun setSendBtnStateFlags(flags: Set<SendBtnStateFlag>) {
        state = state.copy(sendBtnStateFlags = flags)
    }

    override fun setIsSubmitting(value: Boolean) {
        state = state.copy(isSubmitting = value)
    }

    override fun updateState(transform: (FormState) -> FormState) {
        state = transform(state)
    }

    // ==================== Intent ====================

    override fun emitIntent(intent: FormIntent) {
        intents.add(intent)
    }

    // ==================== Result ====================

    fun result(): FormReducerResult = FormReducerResult(state, intents.lastOrNull())

    fun collectedIntents(): List<FormIntent> = intents.toList()
}

