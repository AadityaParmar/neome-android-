// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.msg

import kotlinx.serialization.json.JsonElement
import com.neome.api.nucleus.base.msg.Msg

interface MsgCallerDeviceState : Msg
{
  val state: JsonElement
}