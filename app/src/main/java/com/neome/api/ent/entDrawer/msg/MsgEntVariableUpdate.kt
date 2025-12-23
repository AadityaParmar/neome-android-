// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entDrawer.msg

import com.google.gson.JsonElement
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.nucleus.base.msg.Msg

open class MsgEntVariableUpdate : Msg()
{
  var variableObjectMap: Map<MetaIdVar, Any>? = null
}