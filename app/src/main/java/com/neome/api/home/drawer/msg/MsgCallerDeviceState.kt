// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.msg

import com.neome.api.nucleus.base.msg.Msg

open class MsgCallerDeviceState : Msg() {
    lateinit var state: Object
}
