// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.msg

import kotlinx.serialization.json.JsonElement
import com.neome.api.core.base.msg.MsgVersion

interface MsgCallerSettingPut : MsgVersion
{
  val userSetting: JsonElement
}