// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntPluginDev
import com.neome.api.meta.base.dto.StudioEntPluginJar
import com.neome.api.meta.base.dto.StudioEntPluginRpc

interface StudioEntPluginResourceMap : StudioBase
{
  val dev: StudioEntPluginDev?
  val jar: StudioEntPluginJar?
  val rpc: StudioEntPluginRpc?
}