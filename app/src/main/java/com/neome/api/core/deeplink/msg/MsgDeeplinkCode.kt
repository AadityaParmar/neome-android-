// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.deeplink.msg

import com.neome.api.meta.base.Types.EnumDeviceType
import com.neome.api.nucleus.base.msg.Msg

open class MsgDeeplinkCode : Msg() {
    lateinit var deeplinkCode: String
    var deviceName: String? = null
    var deviceType: EnumDeviceType? = null
}
