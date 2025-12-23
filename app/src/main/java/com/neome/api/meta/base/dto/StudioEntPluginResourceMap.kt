// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntPluginDev
import com.neome.api.meta.base.dto.StudioEntPluginJar
import com.neome.api.meta.base.dto.StudioEntPluginRpc

open class StudioEntPluginResourceMap : StudioBase()
{
  var dev: StudioEntPluginDev? = null
  var jar: StudioEntPluginJar? = null
  var rpc: StudioEntPluginRpc? = null
}