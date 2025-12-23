// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioPluginDev
import com.neome.api.meta.base.dto.StudioPluginJar
import com.neome.api.meta.base.dto.StudioPluginRpc

open class StudioPluginResourceMap : StudioBase()
{
  var dev: StudioPluginDev? = null
  var jar: StudioPluginJar? = null
  var rpc: StudioPluginRpc? = null
}