// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.msg

import com.neome.api.core.base.msg.MsgHandle
import com.neome.api.meta.base.Types.EnumDeviceType
import kotlin.properties.Delegates

open class MsgSignIn : MsgHandle() {
    lateinit var deviceName: String
    lateinit var deviceType: EnumDeviceType
    lateinit var password: String
    var rememberMe: Boolean by Delegates.notNull<Boolean>()
}
