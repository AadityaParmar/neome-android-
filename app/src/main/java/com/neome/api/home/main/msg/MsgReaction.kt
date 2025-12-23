// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.msg

import com.neome.api.core.base.dto.DtoChatMessageOffset

open class MsgReaction : MsgOffset() {
    var chatMessageOffset: DtoChatMessageOffset? = null
    var reaction: String? = null
}
