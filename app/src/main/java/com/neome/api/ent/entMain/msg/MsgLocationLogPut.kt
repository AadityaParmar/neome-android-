// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import kotlinx.serialization.json.JsonElement
import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.msg.Msg

interface MsgLocationLogPut : Msg
{
  val entIdSet: List<EntId>
  val name: String
  val summary: JsonElement
}