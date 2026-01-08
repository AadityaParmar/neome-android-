// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.dto.EntUserIdTriple
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.meta.base.Types.MetaIdPlugin
import com.neome.api.meta.base.Types.PluginApiId
import com.neome.api.meta.base.Types.RequestId

interface DtoPluginApiRequestPayload
{
  val callerTriplet: EntUserIdTriple?
  val pluginApiId: PluginApiId
  val pluginId: MetaIdPlugin
  val pluginInputFormValue: FormValueRaw?
  val requestId: RequestId
  val responseActorPath: String
}