// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.msg

import com.neome.api.core.base.msg.MsgHandle
import com.neome.api.meta.base.Types.EnumDeviceType

class MsgSignIn : MsgHandle() {
    val deviceName: string
    val deviceType: EnumDeviceType
    val password: string
    val rememberMe: boolean
}
