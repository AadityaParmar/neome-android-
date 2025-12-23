// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.msg

import kotlin.properties.Delegates
import com.neome.api.meta.base.Types.EnumDeviceType
import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.meta.base.Types.UserId

open class MsgSignInUserId : Msg()
{
  lateinit var deviceName: String
  lateinit var deviceType: EnumDeviceType
  lateinit var password: String
  var rememberMe: Boolean by Delegates.notNull<Boolean>()
  lateinit var userId: UserId
}