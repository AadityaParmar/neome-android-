package com.neome.feature.form.domain.ctx

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoFormThemeData
import com.neome.core.common.serializer.api.meta.base.dto.FormValueData
import com.neome.feature.form.domain.DefnFormUi
import com.neome.feature.form.domain.ctx.base.FormCtxEventHelper
import com.neome.feature.form.domain.ctx.base.FormCtxInitHelper
import com.neome.feature.form.domain.ctx.base.FormCtxSendBtnStateHelper
import com.neome.feature.form.domain.ctx.base.FormCtxValidationHelper
import com.neome.feature.form.domain.ctx.base.FormReducerResult
import com.neome.feature.form.domain.ctx.base.ReducerFormStateAccessor
import com.neome.feature.form.domain.ref.FormRef
import com.neome.feature.form.domain.ref.FormRefImpl
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.form.presentation.state.FormEvent
import com.neome.feature.form.presentation.state.FormIntent
import com.neome.feature.form.presentation.state.FormState

class FormCtxImpl(
    defnForm: DefnFormUi,
    initialValue: FormValueData?,
    private val onIntent: (FormIntent) -> Unit
) : FormCtx {

    private val _formState = mutableStateOf(
        FormCtxInitHelper.initializeFormState(defnForm, initialValue)
    )

    override val formState: State<FormState> get() = _formState

    private val currentState: FormState get() = _formState.value

    init {
        onIntent(
            FormIntent.SendBtnStateChanged(
                enabled = _formState.value.isSendBtnEnabled,
                invisible = _formState.value.isSendBtnInvisible
            )
        )
    }

    internal fun dispatch(event: FormEvent) {
        val result = processEvent(currentState, event)
        _formState.value = result.state
        result.intent?.let { onIntent(it) }
    }

    private fun processEvent(state: FormState, event: FormEvent): FormReducerResult {
        val defnForm = state.defnForm ?: return FormReducerResult(state)
        val accessor = ReducerFormStateAccessor(state)

        when (event) {
            is FormEvent.FieldValueChanged -> FormCtxEventHelper.handleFieldValueChanged(accessor, event, defnForm)
            is FormEvent.FieldFocused -> FormCtxEventHelper.handleFieldFocused(accessor, event)
            is FormEvent.FieldBlurred -> FormCtxEventHelper.handleFieldBlurred(accessor, event)
            is FormEvent.FieldTouched -> FormCtxEventHelper.handleFieldTouched(accessor, event)
            is FormEvent.TriggerField -> FormCtxEventHelper.handleTriggerField(accessor, event, defnForm)
            is FormEvent.ValidateField -> FormCtxValidationHelper.handleValidateField(accessor, event)
            is FormEvent.ValidateAll -> FormCtxValidationHelper.handleValidateAll(accessor)
            is FormEvent.SetFieldError -> FormCtxValidationHelper.handleSetFieldError(accessor, event)
            is FormEvent.ClearFieldError -> FormCtxValidationHelper.handleClearFieldError(accessor, event)
            is FormEvent.ClearAllErrors -> FormCtxValidationHelper.handleClearAllErrors(accessor)
            is FormEvent.Submit -> FormCtxEventHelper.handleSubmit(accessor, defnForm)
            is FormEvent.Reset -> FormCtxEventHelper.handleReset(accessor, event)
            is FormEvent.SetValues -> FormCtxEventHelper.handleSetValues(accessor, event, defnForm)
            is FormEvent.AddSendBtnStateFlag -> FormCtxSendBtnStateHelper.handleAddSendBtnStateFlag(accessor, event)
            is FormEvent.RemoveSendBtnStateFlag -> FormCtxSendBtnStateHelper.handleRemoveSendBtnStateFlag(
                accessor,
                event
            )

            is FormEvent.Click -> FormCtxEventHelper.handleClick(accessor, event, defnForm)
        }

        return accessor.result()
    }

    fun createFormRef(): FormRef {
        return FormRefImpl(
            getFormState = { currentState },
            dispatchEvent = ::dispatch
        )
    }

    // ==================== FormCtx Implementation ====================


    override fun getFieldState(fieldId: MetaIdComp): FieldState? = currentState.getFieldState(fieldId)
    override fun getDefnFormTheme(): DefnDtoFormThemeData? = currentState.defnForm?.theme
}
