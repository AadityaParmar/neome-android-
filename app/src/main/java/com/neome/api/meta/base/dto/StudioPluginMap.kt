// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.PluginId
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioPlugin

open class StudioPluginMap : StudioBase()
{
  lateinit var keys: Array<PluginId>
  lateinit var map: Map<PluginId, StudioPlugin>
}