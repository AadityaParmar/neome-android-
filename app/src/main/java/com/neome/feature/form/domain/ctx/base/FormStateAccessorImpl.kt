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
 * Mutable accessor for [FormState] used during a single reducer cycle.
 *
 * Design rationale — type-safety against silent field loss:
 *
 *  • **Hot-path collections** (valueMap, fieldStates, errors, sendBtnStateFlags) are extracted
 *    into mutable copies for O(1) per-field mutations during a reducer cycle. These are the
 *    only fields that need collection-level mutation and are synced back in [snapshot].
 *
 *  • **All other fields** (scalar flags, categorizedEvents, formEventPropsMap, …) are mutated
 *    directly on [currentState] via `copy()`. Because `copy()` operates on the real [FormState],
 *    new fields added to [FormState] are automatically carried forward — there is no parallel
 *    data class to keep in sync, so the bug class of "forgot to add field to MutableFormState"
 *    is structurally eliminated.
 *
 *  • [snapshot] merges the hot-path collections back into [currentState]. Only the four
 *    collection fields are listed here; adding a new *scalar* field to [FormState] requires
 *    zero changes in this class.
 */
class ReducerFormStateAccessor(initialState: FormState) : FormStateAccessor {

    /**
     * Running immutable state — source of truth for all scalar / cold-path fields.
     * Mutated in-place via `copy()` for scalar updates.
     */
    private var currentState: FormState = initialState

    // ── Hot-path mutable collections ────────────────────────────────────────
    // Extracted once at construction, synced back in [snapshot].
    private val _valueMap: MutableMap<MetaIdComp, JsonElement> = initialState.valueMap.toMutableMap()
    private val _fieldStates: MutableMap<MetaIdComp, FieldState> = initialState.fieldStates.toMutableMap()
    private val _errors: MutableMap<MetaIdComp, FieldError> = initialState.errors.toMutableMap()
    private val _sendBtnStateFlags: MutableSet<SendBtnStateFlag> = initialState.sendBtnStateFlags.toMutableSet()

    private val intents = mutableListOf<FormIntent>()

    // ==================== Read Methods ====================

    override fun getState(): FormState = snapshot()

    override fun getValue(fieldId: MetaIdComp): JsonElement? = _valueMap[fieldId]

    override fun getFieldState(fieldId: MetaIdComp): FieldState? = _fieldStates[fieldId]

    override fun getValueMap(): Map<MetaIdComp, JsonElement> = _valueMap.toMap()


    override fun getFieldProperties(fieldId: MetaIdComp): FieldProperties? =
        _fieldStates[fieldId]?.fieldProperties

    // ==================== Write Methods ====================

    override fun setValue(fieldId: MetaIdComp, value: JsonElement?) {
        if (value != null) {
            _valueMap[fieldId] = value
        } else {
            _valueMap.remove(fieldId)
        }
    }

    override fun removeValue(fieldId: MetaIdComp) {
        _valueMap.remove(fieldId)
    }

    override fun setFieldState(fieldId: MetaIdComp, fieldState: FieldState) {
        _fieldStates[fieldId] = fieldState
    }

    override fun updateFieldStates(fieldStates: Map<MetaIdComp, FieldState>) {
        _fieldStates.putAll(fieldStates)
    }

    override fun setError(fieldId: MetaIdComp, error: FieldError?) {
        if (error == null) clearError(fieldId) else _errors[fieldId] = error
    }

    override fun clearError(fieldId: MetaIdComp) {
        _errors.remove(fieldId)
    }

    override fun updateErrors(errors: Map<MetaIdComp, FieldError>) {
        _errors.putAll(errors)
    }

    override fun clearAllErrors() {
        _errors.clear()
    }

    override fun setFormEventPropsMap(map: Map<MetaIdComp, FormEventProps>) {
        currentState = currentState.copy(formEventPropsMap = map)
    }

    override fun setSendBtnStateFlags(flags: Set<SendBtnStateFlag>) {
        _sendBtnStateFlags.clear()
        _sendBtnStateFlags.addAll(flags)
    }

    override fun setIsSubmitting(value: Boolean) {
        currentState = currentState.copy(isSubmitting = value)
    }

    override fun updateState(transform: (FormState) -> FormState) {
        val transformed = transform(snapshot())
        // Re-sync: adopt the transformed state wholesale, re-extract mutable collections
        currentState = transformed
        syncCollectionsFrom(transformed)
    }

    // ==================== Intent ====================

    override fun emitIntent(intent: FormIntent) {
        intents.add(intent)
    }

    // ==================== Result ====================

    fun result(): FormReducerResult = FormReducerResult(
        state = snapshot(),
        intents = collectedIntents()
    )

    fun collectedIntents(): List<FormIntent> = intents.toList()

    // ==================== Internal ====================

    /**
     * Merge the four hot-path collections back into [currentState].
     *
     * Only these four fields are listed because they are the only ones extracted
     * into separate mutable collections. Every other field already lives in
     * [currentState] and is carried through automatically by `copy()`.
     */
    private fun snapshot(): FormState = currentState.copy(
        valueMap = _valueMap.toMap(),
        fieldStates = _fieldStates.toMap(),
        errors = _errors.toMap(),
        sendBtnStateFlags = _sendBtnStateFlags.toSet()
    )

    /**
     * Re-populate mutable collections from an immutable [FormState].
     * Called after [updateState] to stay in sync with a wholesale state replacement.
     */
    private fun syncCollectionsFrom(state: FormState) {
        _valueMap.clear()
        _valueMap.putAll(state.valueMap)

        _fieldStates.clear()
        _fieldStates.putAll(state.fieldStates)

        _errors.clear()
        _errors.putAll(state.errors)

        _sendBtnStateFlags.clear()
        _sendBtnStateFlags.addAll(state.sendBtnStateFlags)
    }
}
