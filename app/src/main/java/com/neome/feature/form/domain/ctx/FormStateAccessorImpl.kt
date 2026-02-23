package com.neome.feature.form.domain.ctx

import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.feature.form.domain.ctx.helper.FormReducerResult
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldProperties
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.form.presentation.state.FormEvent
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

    /**
     * Get final result: accumulated state + last intent.
     * Matches the current [FormReducerResult] pattern used by form reducers.
     *
     * @return FormReducerResult with final state and last emitted intent (if any)
     */
    fun result(): FormReducerResult = FormReducerResult(state, intents.lastOrNull())

    /**
     * Get all collected intents.
     * Use when multiple intents need to be processed (e.g., for analytics or side-effect handlers).
     *
     * @return Immutable list of all intents emitted during this accessor's lifetime
     */
    fun collectedIntents(): List<FormIntent> = intents.toList()
}

/**
 * Accessor for external/FormRef-like context.
 * Reads delegate to getFormState(), writes dispatch FormEvents.
 * Used when external code needs the same accessor API but routes through dispatch.
 *
 * Limitations:
 * - Write operations that don't have direct FormEvent equivalents (e.g., bulk state updates,
 *   setFormEventPropsMap) throw UnsupportedOperationException.
 * - emitIntent is a no-op in dispatch context (intents are already managed by the dispatch loop).
 * - updateState is not supported (use event-based mutations instead).
 */
class DispatchFormStateAccessor(
    private val getFormState: () -> FormState,
    private val dispatchEvent: (FormEvent) -> Unit
) : FormStateAccessor {

    // ==================== Read Methods ====================

    override fun getState(): FormState = getFormState()

    override fun getValue(fieldId: MetaIdComp): JsonElement? = getFormState().getValue(fieldId)

    override fun getFieldState(fieldId: MetaIdComp): FieldState? = getFormState().getFieldState(fieldId)

    override fun getError(fieldId: MetaIdComp): FieldError? = getFormState().getError(fieldId)

    override fun getValueMap(): Map<MetaIdComp, JsonElement> = getFormState().valueMap

    override fun getFieldStates(): Map<MetaIdComp, FieldState> = getFormState().fieldStates

    override fun getErrors(): Map<MetaIdComp, FieldError> = getFormState().errors

    override fun getFieldProperties(fieldId: MetaIdComp): FieldProperties? =
        getFormState().getFieldState(fieldId)?.fieldProperties

    // ==================== Write Methods ====================

    override fun setValue(fieldId: MetaIdComp, value: JsonElement?) {
        dispatchEvent(FormEvent.FieldValueChanged(fieldId, value, depth = 0))
    }

    override fun removeValue(fieldId: MetaIdComp) {
        // No direct event for removal — dispatch with null value
        dispatchEvent(FormEvent.FieldValueChanged(fieldId, null, depth = 0))
    }

    override fun setFieldState(fieldId: MetaIdComp, fieldState: FieldState) {
        // No direct event for field state update
        throw UnsupportedOperationException(
            "setFieldState is not supported in dispatch context. " +
                    "Field state updates must be managed through form events (FieldValueChanged, " +
                    "FieldFocused, FieldBlurred, TriggerField, etc.)."
        )
    }

    override fun updateFieldStates(fieldStates: Map<MetaIdComp, FieldState>) {
        // Bulk update not supported in dispatch context
        throw UnsupportedOperationException(
            "updateFieldStates is not supported in dispatch context. " +
                    "Use individual setFieldState-related events instead."
        )
    }

    override fun setError(fieldId: MetaIdComp, error: FieldError) {
        // Dispatch SetFieldError with error message
        dispatchEvent(FormEvent.SetFieldError(fieldId, error.message))
    }

    override fun clearError(fieldId: MetaIdComp) {
        dispatchEvent(FormEvent.ClearFieldError(fieldId))
    }

    override fun updateErrors(errors: Map<MetaIdComp, FieldError>) {
        // Bulk error update not supported — dispatch individual errors
        errors.forEach { (fieldId, error) ->
            dispatchEvent(FormEvent.SetFieldError(fieldId, error.message))
        }
    }

    override fun clearAllErrors() {
        dispatchEvent(FormEvent.ClearAllErrors)
    }

    override fun setFormEventPropsMap(map: Map<MetaIdComp, FormEventProps>) {
        // No direct event for bulk form event props update
        throw UnsupportedOperationException(
            "setFormEventPropsMap is not supported in dispatch context. " +
                    "Form event properties are managed internally by form event actions."
        )
    }

    override fun setSendBtnStateFlags(flags: Set<SendBtnStateFlag>) {
        // No direct event for bulk flag update
        throw UnsupportedOperationException(
            "setSendBtnStateFlags is not supported in dispatch context. " +
                    "Use addSendBtnStateFlag/removeSendBtnStateFlag events instead."
        )
    }

    override fun setIsSubmitting(value: Boolean) {
        // No direct event for isSubmitting flag
        throw UnsupportedOperationException(
            "setIsSubmitting is not supported in dispatch context. " +
                    "Submitting state is managed through Submit/ValidateAll events."
        )
    }

    override fun updateState(transform: (FormState) -> FormState) {
        // Generic state update not supported in dispatch context
        throw UnsupportedOperationException(
            "updateState is not supported in dispatch context. " +
                    "Use specific FormEvent variants to mutate state instead."
        )
    }

    // ==================== Intent ====================

    override fun emitIntent(intent: FormIntent) {
        // In dispatch context, intents are already managed by the dispatch loop.
        // This is a no-op to maintain interface compliance.
    }
}
