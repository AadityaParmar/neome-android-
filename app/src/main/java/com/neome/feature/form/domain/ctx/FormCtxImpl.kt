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
import com.neome.feature.form.presentation.state.FormAction
import com.neome.feature.form.presentation.state.FormEvent
import com.neome.feature.form.presentation.state.FormIntent
import com.neome.feature.form.presentation.state.FormState
import com.neome.feature.form.presentation.state.SendBtnDisableFlag
import com.neome.feature.form.presentation.state.toFormEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.serialization.json.JsonElement
import java.util.concurrent.atomic.AtomicInteger

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
    private val fieldValueFlows = mutableMapOf<MetaIdComp, StateFlow<JsonElement?>>()
    private val fieldErrorFlows = mutableMapOf<MetaIdComp, StateFlow<FieldError?>>()

    private val processingDispatcher = Dispatchers.Default
    private val activeJobCount = AtomicInteger(0)
    private val idleMutex = Mutex()
    private val activeJobs = mutableSetOf<Job>()

    init {
        _stateFlow = MutableStateFlow(
            FormCtxInitHelper.initializeFormState(defnForm, initialValue)
        )

        // Emit initial send button state
        onIntent(FormIntent.SendBtnStateChanged(enabled = _stateFlow.value.isSendBtnEnabled))
    }

    internal fun dispatch(event: FormEvent) {
        _stateFlow.update { currentState ->
            val result = processEvent(currentState, event)
            result.intent?.let { onIntent(it) }
            result.state
        }
    }

    internal fun enqueue(action: FormAction) {
        activeJobCount.incrementAndGet()
        val job = coroutineScope.launch(processingDispatcher) {
            try {
                val event = action.toFormEvent()
                dispatch(event)
            } finally {
                activeJobCount.decrementAndGet()
                idleMutex.withLock {
                    activeJobs.remove(coroutineContext[Job])
                }
            }
        }
        coroutineScope.launch {
            idleMutex.withLock {
                activeJobs.add(job)
            }
        }
    }

    override suspend fun awaitIdle() {
        // Fast path: no active jobs
        if (activeJobCount.get() == 0) return

        // Wait for all active jobs to complete
        val jobsToAwait = idleMutex.withLock { activeJobs.toList() }
        jobsToAwait.forEach { it.join() }

        // Recursive check in case new jobs were added during wait
        if (activeJobCount.get() > 0) {
            awaitIdle()
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
            is FormEvent.AddSendBtnDisableFlag -> handleAddSendBtnDisableFlag(state, event)
            is FormEvent.RemoveSendBtnDisableFlag -> handleRemoveSendBtnDisableFlag(state, event)
        }
    }

    private fun handleAddSendBtnDisableFlag(
        state: FormState,
        event: FormEvent.AddSendBtnDisableFlag
    ): FormReducerResult {
        if (event.flag in state.disableSendBtnSet) {
            return FormReducerResult(state) // No change
        }

        val wasEnabled = state.isSendBtnEnabled
        val newSet = state.disableSendBtnSet + event.flag
        val newState = state.copy(disableSendBtnSet = newSet)

        // Emit intent only on transition: enabled -> disabled
        val intent = if (wasEnabled) {
            FormIntent.SendBtnStateChanged(enabled = false)
        } else null

        return FormReducerResult(newState, intent)
    }

    private fun handleRemoveSendBtnDisableFlag(
        state: FormState,
        event: FormEvent.RemoveSendBtnDisableFlag
    ): FormReducerResult {
        if (event.flag !in state.disableSendBtnSet) {
            return FormReducerResult(state) // No change
        }

        val wasEnabled = state.isSendBtnEnabled
        val newSet = state.disableSendBtnSet - event.flag
        val newState = state.copy(disableSendBtnSet = newSet)
        val isNowEnabled = newState.isSendBtnEnabled

        // Emit intent only on transition: disabled -> enabled
        val intent = if (!wasEnabled && isNowEnabled) {
            FormIntent.SendBtnStateChanged(enabled = true)
        } else null

        return FormReducerResult(newState, intent)
    }

    fun createFormRef(): FormRef {
        return FormRefImpl(
            formStateFlow = stateFlow,
            enqueueAction = ::enqueue,
            coroutineScope = coroutineScope,
            awaitIdleFn = ::awaitIdle
        )
    }

    override fun trigger(fieldId: MetaIdComp) {
        enqueue(FormAction.Trigger(fieldId))
    }

    override fun getValues(): Map<MetaIdComp, JsonElement> = currentState.valueMap
    override fun getFieldState(fieldId: MetaIdComp): FieldState? = currentState.getFieldState(fieldId)
    override fun getValue(fieldId: MetaIdComp): JsonElement? = currentState.getValue(fieldId)
    override fun getError(fieldId: MetaIdComp): FieldError? = currentState.getError(fieldId)
    override fun hasField(fieldId: MetaIdComp): Boolean = currentState.fieldStates.containsKey(fieldId)
    override fun getDefnForm(): DefnFormData? = currentState.defnForm

    override fun validate(fieldId: MetaIdComp?): Boolean {
        enqueue(FormAction.Validate(fieldId))
        return if (fieldId != null) {
            !currentState.hasError(fieldId)
        } else {
            currentState.isValid
        }
    }

    override fun setError(fieldId: MetaIdComp, error: String) {
        enqueue(FormAction.SetError(fieldId, error))
    }

    override fun clearError(fieldId: MetaIdComp) {
        enqueue(FormAction.ClearError(fieldId))
    }

    override fun watchFieldState(fieldId: MetaIdComp): StateFlow<FieldState?> {
        return fieldStateFlows.getOrPut(fieldId) {
            FormCtxStateHelper.createFieldStateFlow(stateFlow, fieldId, coroutineScope)
        }
    }

    override fun watchFieldValue(fieldId: MetaIdComp): StateFlow<JsonElement?> {
        return fieldValueFlows.getOrPut(fieldId) {
            FormCtxStateHelper.createFieldValueFlow(stateFlow, fieldId, coroutineScope)
        }
    }

    override fun watchFieldError(fieldId: MetaIdComp): StateFlow<FieldError?> {
        return fieldErrorFlows.getOrPut(fieldId) {
            FormCtxStateHelper.createFieldErrorFlow(stateFlow, fieldId, coroutineScope)
        }
    }

    override fun watchFormState(): StateFlow<FormState> = stateFlow

    override fun addSendBtnDisableFlag(flag: SendBtnDisableFlag) {
        enqueue(FormAction.AddSendBtnFlag(flag))
    }

    override fun removeSendBtnDisableFlag(flag: SendBtnDisableFlag) {
        enqueue(FormAction.RemoveSendBtnFlag(flag))
    }
}
