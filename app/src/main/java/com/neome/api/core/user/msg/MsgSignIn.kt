// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.msg

import kotlin.properties.Delegates
import com.neome.api.meta.base.Types.EnumDeviceType
import com.neome.api.core.base.msg.MsgHandle

open class MsgSignIn : MsgHandle()
{
  lateinit var deviceName: String
  lateinit var deviceType: EnumDeviceType
  lateinit var password: String
  var rememberMe: Boolean by Delegates.notNull<Boolean>()
}