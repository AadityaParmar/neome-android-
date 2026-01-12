package com.neome.feature.form.presentation.ctx

import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.form.presentation.state.FormEvent
import com.neome.feature.form.presentation.state.FormState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.serialization.json.JsonElement

/**
 * Implementation of FormCtx that provides internal form operations.
 *
 * @param formStateFlow StateFlow of the current FormState
 * @param dispatchEvent Function to dispatch FormEvent
 * @param coroutineScope Scope for StateFlow transformations
 */
class FormCtxImpl(
    private val formStateFlow: StateFlow<FormState>,
    private val dispatchEvent: (FormEvent) -> Unit,
    private val coroutineScope: CoroutineScope
) : FormCtx {

    private val currentState: FormState
        get() = formStateFlow.value

    override fun trigger(fieldId: MetaIdComp) {
        dispatchEvent(FormEvent.TriggerField(fieldId))
    }

    override fun getValues(): Map<MetaIdComp, JsonElement> {
        return currentState.getValueMap()
    }

    override fun getFieldState(fieldId: MetaIdComp): FieldState? {
        return currentState.getFieldState(fieldId)
    }

    override fun getValue(fieldId: MetaIdComp): JsonElement? {
        return currentState.getValue(fieldId)
    }

    override fun hasField(fieldId: MetaIdComp): Boolean {
        return currentState.fieldStates.containsKey(fieldId)
    }

    override fun getDefnForm(): DefnFormData? {
        return currentState.defnForm
    }

    // ==================== Validation ====================

    override fun validate(fieldId: MetaIdComp?): Boolean {
        return if (fieldId != null) {
            dispatchEvent(FormEvent.ValidateField(fieldId))
            !currentState.hasError(fieldId)
        } else {
            dispatchEvent(FormEvent.ValidateAll)
            currentState.isValid
        }
    }

    // ==================== Reactive Streams ====================

    override fun watchFieldState(fieldId: MetaIdComp): StateFlow<FieldState?> {
        return formStateFlow
            .map { it.getFieldState(fieldId) }
            .stateIn(
                scope = coroutineScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = currentState.getFieldState(fieldId)
            )
    }

    override fun watchFormState(): StateFlow<FormState> {
        return formStateFlow
    }
}
