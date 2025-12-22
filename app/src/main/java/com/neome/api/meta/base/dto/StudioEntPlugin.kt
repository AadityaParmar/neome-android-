// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPluginMode
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.Types.PluginApiId
import com.neome.api.meta.base.Types.PluginBundleId
import com.neome.api.meta.base.Types.PluginId

class StudioEntPlugin : StudioEntImport() {
    val mode: EnumDefnPluginMode
    var pluginAbout: string? = null
    val pluginApiIdKeys: PluginApiId[]
    val pluginApiIdMap: Record<PluginApiId, StudioEntPluginApi>
    var pluginAvatarId: MediaIdAvatar? = null
    val pluginBundleId: PluginBundleId
    var pluginConfigFormId: MetaIdForm? = null
    val pluginFormKeys: MetaIdForm[]
    val pluginFormMap: Record<MetaIdForm, DefnForm>
    val pluginId: PluginId
    val pluginName: string
    var pluginResourceMap: StudioEntPluginResourceMap? = null
    val pluginVarKeys: MetaIdVar[]
    val pluginVarMap: Record<MetaIdVar, StudioVar>
    val pluginVersion: string
    var singleton: boolean? = null
}
