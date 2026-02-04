package com.neome.feature.form.domain.ctx

import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import com.neome.feature.form.domain.ctx.helper.FormCtxEventHelper
import com.neome.feature.form.domain.ctx.helper.FormCtxInitHelper
import com.neome.feature.form.domain.ctx.helper.FormCtxStateHelper
import com.neome.feature.form.domain.ctx.helper.FormCtxValidationHelper
import com.neome.feature.form.domain.ctx.helper.FormReducerResult
import com.neome.feature.form.domain.ref.FormRef
import com.neome.feature.form.domain.ref.FormRefImpl
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.form.presentation.state.FormEvent
import com.neome.feature.form.presentation.state.FormIntent
import com.neome.feature.form.presentation.state.FormState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.serialization.json.JsonElement

class FormCtxImpl(
    private val defnForm: DefnFormData,
    initialValue: FormValueRawData?,
    private val coroutineScope: CoroutineScope,
    private val onIntent: (FormIntent) -> Unit
) : FormCtx {

    private val _stateFlow: MutableStateFlow<FormState>

    internal val stateFlow: StateFlow<FormState> get() = _stateFlow.asStateFlow()

    private val currentState: FormState get() = _stateFlow.value

    private val fieldStateFlows = mutableMapOf<MetaIdComp, StateFlow<FieldState?>>()
    private val fieldErrorFlows = mutableMapOf<MetaIdComp, StateFlow<FieldError?>>()

    init {
        _stateFlow = MutableStateFlow(
            FormCtxInitHelper.initializeFormState(defnForm, initialValue)
        )
    }

    internal fun dispatch(event: FormEvent) {
        _stateFlow.update { currentState ->
            val result = processEvent(currentState, event)
            result.intent?.let { onIntent(it) }
            result.state
        }
    }

    private fun processEvent(state: FormState, event: FormEvent): FormReducerResult {
        val defnForm = state.defnForm ?: return FormReducerResult(state)

        return when (event) {
            is FormEvent.Initialize -> FormReducerResult(state)
            is FormEvent.FieldValueChanged -> FormCtxEventHelper.handleFieldValueChanged(state, event, defnForm)
            is FormEvent.FieldFocused -> FormCtxEventHelper.handleFieldFocused(state, event)
            is FormEvent.FieldBlurred -> FormCtxEventHelper.handleFieldBlurred(state, event)
            is FormEvent.FieldTouched -> FormCtxEventHelper.handleFieldTouched(state, event)
            is FormEvent.TriggerField -> FormCtxEventHelper.handleTriggerField(state, event, defnForm)
            is FormEvent.ValidateField -> FormCtxValidationHelper.handleValidateField(state, event)
            is FormEvent.ValidateAll -> FormCtxValidationHelper.handleValidateAll(state)
            is FormEvent.SetFieldError -> FormCtxValidationHelper.handleSetFieldError(state, event)
            is FormEvent.ClearFieldError -> FormCtxValidationHelper.handleClearFieldError(state, event)
            is FormEvent.ClearAllErrors -> FormCtxValidationHelper.handleClearAllErrors(state)
            is FormEvent.Submit -> FormCtxEventHelper.handleSubmit(state)
            is FormEvent.Reset -> FormCtxEventHelper.handleReset(state, event)
            is FormEvent.SetValues -> FormCtxEventHelper.handleSetValues(state, event)
        }
    }

    fun createFormRef(): FormRef {
        return FormRefImpl(
            formStateFlow = stateFlow,
            dispatchEvent = ::dispatch,
            coroutineScope = coroutineScope
        )
    }

    override fun trigger(fieldId: MetaIdComp) {
        dispatch(FormEvent.TriggerField(fieldId))
    }

    override fun getValues(): Map<MetaIdComp, JsonElement> = currentState.getValueMap()
    override fun getFieldState(fieldId: MetaIdComp): FieldState? = currentState.getFieldState(fieldId)
    override fun getValue(fieldId: MetaIdComp): JsonElement? = currentState.getValue(fieldId)
    override fun getError(fieldId: MetaIdComp): FieldError? = currentState.getError(fieldId)
    override fun hasField(fieldId: MetaIdComp): Boolean = currentState.fieldStates.containsKey(fieldId)
    override fun getDefnForm(): DefnFormData? = currentState.defnForm

    override fun validate(fieldId: MetaIdComp?): Boolean {
        return if (fieldId != null) {
            dispatch(FormEvent.ValidateField(fieldId))
            !currentState.hasError(fieldId)
        } else {
            dispatch(FormEvent.ValidateAll)
            currentState.isValid
        }
    }

    override fun setError(fieldId: MetaIdComp, error: String) {
        dispatch(FormEvent.SetFieldError(fieldId, error))
    }

    override fun clearError(fieldId: MetaIdComp) {
        dispatch(FormEvent.ClearFieldError(fieldId))
    }

    override fun watchFieldState(fieldId: MetaIdComp): StateFlow<FieldState?> {
        return fieldStateFlows.getOrPut(fieldId) {
            FormCtxStateHelper.createFieldStateFlow(stateFlow, fieldId, coroutineScope)
        }
    }

    override fun watchFieldError(fieldId: MetaIdComp): StateFlow<FieldError?> {
        return fieldErrorFlows.getOrPut(fieldId) {
            FormCtxStateHelper.createFieldErrorFlow(stateFlow, fieldId, coroutineScope)
        }
    }

    override fun watchFormState(): StateFlow<FormState> = stateFlow
}
