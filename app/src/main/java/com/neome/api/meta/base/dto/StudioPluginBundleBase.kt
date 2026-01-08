// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.Types.PluginBundleId
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioPluginMap

interface StudioPluginBundleBase : StudioBase
{
  val createdBy: AdminId
  val creationTime: String
  val deployMap: StudioPluginMap?
  val pluginBundleId: PluginBundleId
  val updateBy: AdminId
  val updateTime: String
  val version: String
}