// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.msg

import com.neome.api.meta.base.Types.DeviceId
import com.neome.api.core.base.msg.MsgVersion

open class MsgDeviceGet : MsgVersion()
{
  lateinit var deviceId: DeviceId
}