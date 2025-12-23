// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.AdminId
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdPlugin
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntDeployPlugin

open class StudioEntDeployPluginMap : StudioBase()
{
  lateinit var keys: Array<MetaIdPlugin>
  lateinit var map: Map<MetaIdPlugin, StudioEntDeployPlugin>
  var singletonPluginsAdminId: AdminId? = null
}