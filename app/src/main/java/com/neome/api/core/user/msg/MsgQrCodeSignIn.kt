// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.msg

import com.neome.api.meta.base.Types.EnumDeviceType
import com.neome.api.nucleus.base.msg.Msg

open class MsgQrCodeSignIn : Msg()
{
  lateinit var deviceName: String
  lateinit var deviceType: EnumDeviceType
  var rememberMe: Boolean? = null
}