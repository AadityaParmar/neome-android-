// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdPlugin
import com.neome.api.meta.base.Types.PluginApiId
import com.neome.api.meta.base.dto.StudioBase

interface StudioDtoPluginApi : StudioBase
{
  val metaIdPlugin: MetaIdPlugin?
  val pluginApiId: PluginApiId?
}