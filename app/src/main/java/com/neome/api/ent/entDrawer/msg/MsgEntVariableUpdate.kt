// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entDrawer.msg

import kotlinx.serialization.json.JsonElement
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.nucleus.base.msg.Msg

interface MsgEntVariableUpdate : Msg
{
  val variableObjectMap: Map<MetaIdVar, JsonElement>?
}