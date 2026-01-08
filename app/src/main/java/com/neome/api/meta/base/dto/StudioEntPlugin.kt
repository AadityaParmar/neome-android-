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

interface StudioEntPlugin : StudioEntImport
{
  val mode: EnumDefnPluginMode
  val pluginAbout: String?
  val pluginApiIdKeys: Array<PluginApiId>
  val pluginApiIdMap: Map<PluginApiId, StudioEntPluginApi>
  val pluginAvatarId: MediaIdAvatar?
  val pluginBundleId: PluginBundleId
  val pluginConfigFormId: MetaIdForm?
  val pluginFormKeys: Array<MetaIdForm>
  val pluginFormMap: Map<MetaIdForm, DefnForm>
  val pluginId: PluginId
  val pluginName: String
  val pluginResourceMap: StudioEntPluginResourceMap?
  val pluginVarKeys: Array<MetaIdVar>
  val pluginVarMap: Map<MetaIdVar, StudioVar>
  val pluginVersion: String
  val singleton: Boolean?
}