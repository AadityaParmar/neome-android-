// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.AdminId
import java.util.Date
import com.neome.api.meta.base.Types.EnumDefnPluginMode
import com.neome.api.meta.base.Types.PluginId
import com.neome.api.meta.base.dto.StudioDeployUnit
import com.neome.api.meta.base.dto.StudioFormMap
import com.neome.api.meta.base.dto.StudioModuleMap
import com.neome.api.meta.base.dto.StudioPluginApiMap
import com.neome.api.meta.base.dto.StudioPluginDeploy
import com.neome.api.meta.base.dto.StudioPluginDetails
import com.neome.api.meta.base.dto.StudioPluginResourceMap
import com.neome.api.meta.base.dto.StudioPluginTrash
import com.neome.api.meta.base.dto.StudioStoreItemDetailMap
import com.neome.api.meta.base.dto.StudioVarMap

open class StudioPlugin : StudioDeployUnit()
{
  lateinit var apiMap: StudioPluginApiMap
  var createdBy: AdminId? = null
  var creationTime: String? = null
  lateinit var deploy: StudioPluginDeploy
  var deprecate: Boolean? = null
  lateinit var details: StudioPluginDetails
  lateinit var formMap: StudioFormMap
  var lastUpdateBy: AdminId? = null
  var lastUpdateTime: String? = null
  lateinit var metaId: PluginId
  lateinit var mode: EnumDefnPluginMode
  lateinit var moduleMap: StudioModuleMap
  var resourceMap: StudioPluginResourceMap? = null
  var storeItemDetailMap: StudioStoreItemDetailMap? = null
  var trash: StudioPluginTrash? = null
  lateinit var varMap: StudioVarMap
  var version: String? = null
}