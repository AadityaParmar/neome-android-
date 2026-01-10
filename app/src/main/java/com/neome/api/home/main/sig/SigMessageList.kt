// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import com.neome.api.meta.base.Types.ChatId
import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.sig.Sig

interface SigMessageList : Sig {
    val bottomOffset: Long?
    val chatId: ChatId
    val chatIdHash: String
    val entId: EntId
    val messageList: List<SigMessage>
    val pageBottomOffset: Long?
    val pageTopOffset: Long?
    val readOffset: Long?
    val topOffset: Long?
}
