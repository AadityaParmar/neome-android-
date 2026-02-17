// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.Types.EnumDefnPluginMode
import com.neome.api.meta.base.Types.PluginId
import com.neome.api.meta.base.dto.StudioDeployUnit
import com.neome.api.meta.base.dto.StudioFormMap
import com.neome.api.meta.base.dto.StudioModuleMap
import com.neome.api.meta.base.dto.StudioPluginApiMap
import com.neome.api.meta.base.dto.StudioPluginAuthMap
import com.neome.api.meta.base.dto.StudioPluginDeploy
import com.neome.api.meta.base.dto.StudioPluginDetails
import com.neome.api.meta.base.dto.StudioPluginResourceMap
import com.neome.api.meta.base.dto.StudioPluginTrash
import com.neome.api.meta.base.dto.StudioStoreItemDetailMap
import com.neome.api.meta.base.dto.StudioVarMap

interface StudioPlugin : StudioDeployUnit
{
  val apiMap: StudioPluginApiMap
  val authMap: StudioPluginAuthMap?
  val createdBy: AdminId?
  val creationTime: String?
  val deploy: StudioPluginDeploy
  val deprecate: Boolean?
  val details: StudioPluginDetails
  val formMap: StudioFormMap
  val lastUpdateBy: AdminId?
  val lastUpdateTime: String?
  val metaId: PluginId
  val mode: EnumDefnPluginMode
  val moduleMap: StudioModuleMap
  val resourceMap: StudioPluginResourceMap?
  val storeItemDetailMap: StudioStoreItemDetailMap?
  val trash: StudioPluginTrash?
  val varMap: StudioVarMap
  val version: String?
}