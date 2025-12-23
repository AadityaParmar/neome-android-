// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.Types.EnumDefnPluginMode
import java.util.Map
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.Types.PluginApiId
import com.neome.api.meta.base.Types.PluginBundleId
import com.neome.api.meta.base.Types.PluginId
import com.neome.api.meta.base.dto.StudioEntImport
import com.neome.api.meta.base.dto.StudioEntPluginApi
import com.neome.api.meta.base.dto.StudioEntPluginResourceMap
import com.neome.api.meta.base.dto.StudioVar

open class StudioEntPlugin : StudioEntImport()
{
  lateinit var mode: EnumDefnPluginMode
  var pluginAbout: String? = null
  lateinit var pluginApiIdKeys: Array<PluginApiId>
  lateinit var pluginApiIdMap: Map<PluginApiId, StudioEntPluginApi>
  var pluginAvatarId: MediaIdAvatar? = null
  lateinit var pluginBundleId: PluginBundleId
  var pluginConfigFormId: MetaIdForm? = null
  lateinit var pluginFormKeys: Array<MetaIdForm>
  lateinit var pluginFormMap: Map<MetaIdForm, DefnForm>
  lateinit var pluginId: PluginId
  lateinit var pluginName: String
  var pluginResourceMap: StudioEntPluginResourceMap? = null
  lateinit var pluginVarKeys: Array<MetaIdVar>
  lateinit var pluginVarMap: Map<MetaIdVar, StudioVar>
  lateinit var pluginVersion: String
  var singleton: Boolean? = null
}