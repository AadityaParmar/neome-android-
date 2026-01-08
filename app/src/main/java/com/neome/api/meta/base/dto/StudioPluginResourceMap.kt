// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioPluginDev
import com.neome.api.meta.base.dto.StudioPluginJar
import com.neome.api.meta.base.dto.StudioPluginRpc

interface StudioPluginResourceMap : StudioBase
{
  val dev: StudioPluginDev?
  val jar: StudioPluginJar?
  val rpc: StudioPluginRpc?
}