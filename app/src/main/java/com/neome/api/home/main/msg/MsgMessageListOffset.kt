// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.msg

import kotlin.properties.Delegates

open class MsgMessageListOffset : MsgMessageList() {
    var offset: Number by Delegates.notNull<Number>()
}
