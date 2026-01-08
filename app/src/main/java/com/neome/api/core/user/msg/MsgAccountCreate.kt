// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.msg

import com.neome.api.meta.base.Types.EnumDeviceType
import com.neome.api.meta.base.Types.LanguageKey
import com.neome.api.core.base.msg.MsgHandle

interface MsgAccountCreate : MsgHandle
{
  val deviceName: String
  val deviceType: EnumDeviceType
  val firstName: String
  val languageKey: LanguageKey?
  val lastName: String
  val newPassword: String
}