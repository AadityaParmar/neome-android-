package com.neome.feature.form.domain.ctx

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import com.neome.feature.form.domain.ctx.helper.FormCtxEventHelper
import com.neome.feature.form.domain.ctx.helper.FormCtxInitHelper
import com.neome.feature.form.domain.ctx.helper.FormCtxValidationHelper
import com.neome.feature.form.domain.ctx.helper.FormReducerResult
import com.neome.feature.form.domain.ref.FormRef
import com.neome.feature.form.domain.ref.FormRefImpl
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.form.presentation.state.FormEvent
import com.neome.feature.form.presentation.state.FormIntent
import com.neome.feature.form.presentation.state.FormState
import com.neome.feature.form.presentation.state.SendBtnDisableFlag
import kotlinx.serialization.json.JsonElement

class FormCtxImpl(
    private val defnForm: DefnFormData,
    initialValue: FormValueRawData?,
    private val onIntent: (FormIntent) -> Unit
) : FormCtx {

    private val _formState = mutableStateOf(
        FormCtxInitHelper.initializeFormState(defnForm, initialValue)
    )

    override val formState: State<FormState> get() = _formState

    private val currentState: FormState get() = _formState.value

    init {
        onIntent(FormIntent.SendBtnStateChanged(enabled = _formState.value.isSendBtnEnabled))
    }

    internal fun dispatch(event: FormEvent) {
        val result = processEvent(currentState, event)
        _formState.value = result.state
        result.intent?.let { onIntent(it) }
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
            is FormEvent.SetValues -> FormCtxEventHelper.handleSetValues(state, event, defnForm)
            is FormEvent.AddSendBtnDisableFlag -> handleAddSendBtnDisableFlag(state, event)
            is FormEvent.RemoveSendBtnDisableFlag -> handleRemoveSendBtnDisableFlag(state, event)
        }
    }

    private fun handleAddSendBtnDisableFlag(
        state: FormState,
        event: FormEvent.AddSendBtnDisableFlag
    ): FormReducerResult {
        if (event.flag in state.disableSendBtnSet) return FormReducerResult(state)
        val wasEnabled = state.isSendBtnEnabled
        val newSet = state.disableSendBtnSet + event.flag
        val newState = state.copy(disableSendBtnSet = newSet)
        val intent = if (wasEnabled) FormIntent.SendBtnStateChanged(enabled = false) else null
        return FormReducerResult(newState, intent)
    }

    private fun handleRemoveSendBtnDisableFlag(
        state: FormState,
        event: FormEvent.RemoveSendBtnDisableFlag
    ): FormReducerResult {
        if (event.flag !in state.disableSendBtnSet) return FormReducerResult(state)
        val wasEnabled = state.isSendBtnEnabled
        val newSet = state.disableSendBtnSet - event.flag
        val newState = state.copy(disableSendBtnSet = newSet)
        val isNowEnabled = newState.isSendBtnEnabled
        val intent = if (!wasEnabled && isNowEnabled) FormIntent.SendBtnStateChanged(enabled = true) else null
        return FormReducerResult(newState, intent)
    }

    fun createFormRef(): FormRef {
        return FormRefImpl(
            getFormState = { currentState },
            dispatchEvent = ::dispatch
        )
    }

    // ==================== FormCtx Implementation ====================

    override fun trigger(fieldId: MetaIdComp) {
        dispatch(FormEvent.TriggerField(fieldId))
    }

    override fun getValues(): Map<MetaIdComp, JsonElement> = currentState.valueMap
    override fun getFieldState(fieldId: MetaIdComp): FieldState? = currentState.getFieldState(fieldId)
    override fun getValue(fieldId: MetaIdComp): JsonElement? = currentState.getValue(fieldId)
    override fun getError(fieldId: MetaIdComp): FieldError? = currentState.getError(fieldId)
    override fun hasField(fieldId: MetaIdComp): Boolean = currentState.fieldStates.containsKey(fieldId)
    override fun getDefnForm(): DefnFormData? = currentState.defnForm

    override fun validate(fieldId: MetaIdComp?) {
        if (fieldId != null) {
            dispatch(FormEvent.ValidateField(fieldId))
        } else {
            dispatch(FormEvent.ValidateAll)
        }
    }

    override fun setError(fieldId: MetaIdComp, error: String) {
        dispatch(FormEvent.SetFieldError(fieldId, error))
    }

    override fun clearError(fieldId: MetaIdComp) {
        dispatch(FormEvent.ClearFieldError(fieldId))
    }

    override fun addSendBtnDisableFlag(flag: SendBtnDisableFlag) {
        dispatch(FormEvent.AddSendBtnDisableFlag(flag))
    }

    override fun removeSendBtnDisableFlag(flag: SendBtnDisableFlag) {
        dispatch(FormEvent.RemoveSendBtnDisableFlag(flag))
    }
}
