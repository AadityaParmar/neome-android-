package com.neome.feature.form.domain.ctx.helper

import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.form.presentation.state.FormState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.serialization.json.JsonElement

object FormCtxStateHelper {

    fun createFieldStateFlow(
        formStateFlow: StateFlow<FormState>,
        fieldId: MetaIdComp,
        coroutineScope: CoroutineScope
    ): StateFlow<FieldState?> {
        val currentState = formStateFlow.value
        return formStateFlow
            .map { it.getFieldState(fieldId) }
            .distinctUntilChanged()
            .stateIn(
                scope = coroutineScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = currentState.getFieldState(fieldId)
            )
    }

    fun createFieldValueFlow(
        formStateFlow: StateFlow<FormState>,
        fieldId: MetaIdComp,
        coroutineScope: CoroutineScope
    ): StateFlow<JsonElement?> {
        val currentState = formStateFlow.value
        return formStateFlow
            .map { it.getValue(fieldId) }
            .distinctUntilChanged()
            .stateIn(
                scope = coroutineScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = currentState.getValue(fieldId)
            )
    }

    fun createFieldErrorFlow(
        formStateFlow: StateFlow<FormState>,
        fieldId: MetaIdComp,
        coroutineScope: CoroutineScope
    ): StateFlow<FieldError?> {
        val currentState = formStateFlow.value
        return formStateFlow
            .map { it.getError(fieldId) }
            .distinctUntilChanged()
            .stateIn(
                scope = coroutineScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = currentState.getError(fieldId)
            )
    }
}
