package com.neome.feature.form.domain.ctx

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.core.common.serializer.api.meta.base.dto.FormValueData
import com.neome.feature.form.domain.DefnFormUi
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
import com.neome.feature.form.presentation.state.SendBtnStateFlag
import kotlinx.serialization.json.JsonElement

class FormCtxImpl(
    private val defnForm: DefnFormUi,
    initialValue: FormValueData?,
    private val onIntent: (FormIntent) -> Unit
) : FormCtx {

    private val _formState = mutableStateOf(
        FormCtxInitHelper.initializeFormState(defnForm, initialValue)
    )

    override val formState: State<FormState> get() = _formState

    private val currentState: FormState get() = _formState.value

    init {
        onIntent(FormIntent.SendBtnStateChanged(
            enabled = _formState.value.isSendBtnEnabled,
            invisible = _formState.value.isSendBtnInvisible
        ))
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
            is FormEvent.Submit -> FormCtxEventHelper.handleSubmit(state, defnForm)
            is FormEvent.Reset -> FormCtxEventHelper.handleReset(state, event)
            is FormEvent.SetValues -> FormCtxEventHelper.handleSetValues(state, event, defnForm)
            is FormEvent.AddSendBtnStateFlag -> handleAddSendBtnStateFlag(state, event)
            is FormEvent.RemoveSendBtnStateFlag -> handleRemoveSendBtnStateFlag(state, event)
            is FormEvent.Click -> FormCtxEventHelper.handleClick(state, event, defnForm)
        }
    }

    private fun handleAddSendBtnStateFlag(
        state: FormState,
        event: FormEvent.AddSendBtnStateFlag
    ): FormReducerResult {
        if (event.flag in state.sendBtnStateFlags) return FormReducerResult(state)
        val wasEnabled = state.isSendBtnEnabled
        val wasInvisible = state.isSendBtnInvisible
        val newSet = state.sendBtnStateFlags + event.flag
        val newState = state.copy(sendBtnStateFlags = newSet)
        val isNowEnabled = newState.isSendBtnEnabled
        val isNowInvisible = newState.isSendBtnInvisible
        val intent = if (wasEnabled != isNowEnabled || wasInvisible != isNowInvisible) {
            FormIntent.SendBtnStateChanged(enabled = isNowEnabled, invisible = isNowInvisible)
        } else null
        return FormReducerResult(newState, intent)
    }

    private fun handleRemoveSendBtnStateFlag(
        state: FormState,
        event: FormEvent.RemoveSendBtnStateFlag
    ): FormReducerResult {
        if (event.flag !in state.sendBtnStateFlags) return FormReducerResult(state)
        val wasEnabled = state.isSendBtnEnabled
        val wasInvisible = state.isSendBtnInvisible
        val newSet = state.sendBtnStateFlags - event.flag
        val newState = state.copy(sendBtnStateFlags = newSet)
        val isNowEnabled = newState.isSendBtnEnabled
        val isNowInvisible = newState.isSendBtnInvisible
        val intent = if (wasEnabled != isNowEnabled || wasInvisible != isNowInvisible) {
            FormIntent.SendBtnStateChanged(enabled = isNowEnabled, invisible = isNowInvisible)
        } else null
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
    override fun getDefnForm(): DefnFormUi? = currentState.defnForm

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

    override fun addSendBtnStateFlag(flag: SendBtnStateFlag) {
        dispatch(FormEvent.AddSendBtnStateFlag(flag))
    }

    override fun removeSendBtnStateFlag(flag: SendBtnStateFlag) {
        dispatch(FormEvent.RemoveSendBtnStateFlag(flag))
    }
}
