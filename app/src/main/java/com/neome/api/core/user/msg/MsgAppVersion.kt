// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.msg

import kotlin.properties.Delegates
import com.neome.api.meta.base.Types.EnumDeviceType
import com.neome.api.nucleus.base.msg.Msg

open class MsgAppVersion : Msg()
{
  lateinit var deviceType: EnumDeviceType
  var versionCode: Number by Delegates.notNull<Number>()
}