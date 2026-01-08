// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPluginResources
import com.google.gson.JsonElement
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdPlugin
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.Symbol

interface StudioEntDeployPlugin : StudioBase
{
  val metaId: MetaIdPlugin
  val name: Symbol
  val pluginConfigFormValueMap: Map<MetaIdComp, Any>?
  val pluginType: EnumDefnPluginResources?
}