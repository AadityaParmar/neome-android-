// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.msg

import com.neome.api.meta.base.Types.EnumDeviceType
import com.neome.api.meta.base.Types.LanguageKey
import com.neome.api.core.base.msg.MsgHandle

open class MsgAccountCreate : MsgHandle()
{
  lateinit var deviceName: String
  lateinit var deviceType: EnumDeviceType
  lateinit var firstName: String
  var languageKey: LanguageKey? = null
  lateinit var lastName: String
  lateinit var newPassword: String
}