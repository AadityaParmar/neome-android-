package com.neome.feature.form.domain.ctx.base

import com.neome.feature.form.domain.ctx.FormStateAccessor
import com.neome.feature.form.presentation.state.FormEvent
import com.neome.feature.form.presentation.state.FormIntent

object FormCtxSendBtnStateHelper {

    fun handleAddSendBtnStateFlag(
        accessor: FormStateAccessor,
        event: FormEvent.AddSendBtnStateFlag
    ) {
        val state = accessor.getState()
        if (event.flag in state.sendBtnStateFlags) return
        val wasEnabled = state.isSendBtnEnabled
        val wasInvisible = state.isSendBtnInvisible
        accessor.setSendBtnStateFlags(state.sendBtnStateFlags + event.flag)
        val newState = accessor.getState()
        val isNowEnabled = newState.isSendBtnEnabled
        val isNowInvisible = newState.isSendBtnInvisible
        if (wasEnabled != isNowEnabled || wasInvisible != isNowInvisible) {
            accessor.emitIntent(FormIntent.SendBtnStateChanged(enabled = isNowEnabled, invisible = isNowInvisible))
        }
    }

    fun handleRemoveSendBtnStateFlag(
        accessor: FormStateAccessor,
        event: FormEvent.RemoveSendBtnStateFlag
    ) {
        val state = accessor.getState()
        if (event.flag !in state.sendBtnStateFlags) return
        val wasEnabled = state.isSendBtnEnabled
        val wasInvisible = state.isSendBtnInvisible
        accessor.setSendBtnStateFlags(state.sendBtnStateFlags - event.flag)
        val newState = accessor.getState()
        val isNowEnabled = newState.isSendBtnEnabled
        val isNowInvisible = newState.isSendBtnInvisible
        if (wasEnabled != isNowEnabled || wasInvisible != isNowInvisible) {
            accessor.emitIntent(FormIntent.SendBtnStateChanged(enabled = isNowEnabled, invisible = isNowInvisible))
        }
    }
}
