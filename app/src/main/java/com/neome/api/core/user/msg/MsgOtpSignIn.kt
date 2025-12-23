// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.msg

import com.neome.api.core.base.msg.MsgHandle
import com.neome.api.meta.base.Types.EnumDeviceType

open class MsgOtpSignIn : MsgHandle() {
    lateinit var deviceName: String
    lateinit var deviceType: EnumDeviceType
    var rememberMe: Boolean? = null
}
