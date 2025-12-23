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
import java.util.Map

open class DtoPlugin {
    var about: String? = null
    var createdOn: String? = null
    lateinit var kind: EnumDefnKindImport
    lateinit var mode: EnumDefnPluginMode
    var obsolete: Boolean? = null
    var pluginApiIdKeys: Array<PluginApiId>? = null
    var pluginApiIdMap: Map<PluginApiId, StudioEntPluginApi>? = null
    var pluginAvatarId: MediaIdAvatar? = null
    lateinit var pluginBundleId: PluginBundleId
    var pluginConfigFormId: MetaIdForm? = null
    var pluginFormKeys: Array<MetaIdForm>? = null
    var pluginFormMap: Map<MetaIdForm, DefnForm>? = null
    lateinit var pluginId: PluginId
    lateinit var pluginName: String
    lateinit var pluginResourceMap: StudioEntPluginResourceMap
    var pluginVarKeys: Array<MetaIdVar>? = null
    var pluginVarMap: Map<MetaIdVar, StudioVar>? = null
    lateinit var pluginVersion: String
}
