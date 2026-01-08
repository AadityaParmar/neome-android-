// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.PluginApiId
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioPluginApi

interface StudioPluginApiMap : StudioBase
{
  val keys: Array<PluginApiId>
  val map: Map<PluginApiId, StudioPluginApi>
  val pluginConfigFormId: MetaIdForm?
}