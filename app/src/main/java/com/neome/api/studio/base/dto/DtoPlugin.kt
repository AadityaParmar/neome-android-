// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindImport
import com.neome.api.meta.base.Types.EnumDefnPluginMode
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.Types.PluginApiId
import com.neome.api.meta.base.Types.PluginBundleId
import com.neome.api.meta.base.Types.PluginId
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.StudioEntPluginApi
import com.neome.api.meta.base.dto.StudioEntPluginResourceMap
import com.neome.api.meta.base.dto.StudioVar

class DtoPlugin {
    var about: string? = null
    var createdOn: string? = null
    val kind: EnumDefnKindImport
    val mode: EnumDefnPluginMode
    var obsolete: boolean? = null
    var pluginApiIdKeys: PluginApiId[]? = null
    var pluginApiIdMap: Record<PluginApiId, StudioEntPluginApi>? = null
    var pluginAvatarId: MediaIdAvatar? = null
    val pluginBundleId: PluginBundleId
    var pluginConfigFormId: MetaIdForm? = null
    var pluginFormKeys: MetaIdForm[]? = null
    var pluginFormMap: Record<MetaIdForm, DefnForm>? = null
    val pluginId: PluginId
    val pluginName: string
    val pluginResourceMap: StudioEntPluginResourceMap
    var pluginVarKeys: MetaIdVar[]? = null
    var pluginVarMap: Record<MetaIdVar, StudioVar>? = null
    val pluginVersion: string
}
