// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.PluginBundleId
import com.neome.api.meta.base.dto.StudioPlugin

open class StudioCliPlugin : StudioPlugin()
{
  var pluginBundleId: PluginBundleId? = null
}