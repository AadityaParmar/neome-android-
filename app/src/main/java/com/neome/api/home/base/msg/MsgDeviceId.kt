// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.msg

import com.neome.api.meta.base.Types.DeviceId
import com.neome.api.nucleus.base.msg.Msg

class MsgDeviceId : Msg() {
    val deviceId: DeviceId
}
