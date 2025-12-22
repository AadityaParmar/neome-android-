// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import com.neome.api.meta.base.Types.ChatId
import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.sig.Sig

class SigMessageList : Sig() {
    val bottomOffset: number
    val chatId: ChatId
    val chatIdHash: string
    val entId: EntId
    val messageList: SigMessage[]
    val pageBottomOffset: number
    val pageTopOffset: number
    val readOffset: number
    val topOffset: number
}
