package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindImport
import com.neome.api.meta.base.Types.EnumDefnPluginMode
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.StudioEntImport
import com.neome.api.meta.base.dto.StudioEntPlugin
import com.neome.api.meta.base.dto.StudioEntPluginApi
import com.neome.api.meta.base.dto.StudioEntPluginResourceMap
import com.neome.api.meta.base.dto.StudioModuleSelection
import com.neome.api.meta.base.dto.StudioVar
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntPluginApiData
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntPluginResourceMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioModuleSelectionData
import com.neome.core.common.serializer.api.meta.base.dto.StudioVarData
import com.neome.core.common.serializer.sysId.MediaIdAvatarSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdPluginSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import com.neome.core.common.serializer.sysId.PluginApiIdSer
import com.neome.core.common.serializer.sysId.PluginBundleIdSer
import com.neome.core.common.serializer.sysId.PluginIdSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntPluginData(
    override val description: String? = null,
    override val kind: EnumDefnKindImport? = null,
    @Serializable(with = MetaIdPluginSer::class) override val metaId: Types.MetaIdPlugin,
    override val modules: StudioModuleSelectionData? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol? = null,
    override val mode: EnumDefnPluginMode,
    override val pluginAbout: String? = null,
    override val pluginApiIdKeys: List<@Serializable(with = PluginApiIdSer::class) Types.PluginApiId>,
    override val pluginApiIdMap: Map<@Serializable(with = PluginApiIdSer::class) Types.PluginApiId, StudioEntPluginApiData>,
    @Serializable(with = MediaIdAvatarSer::class) override val pluginAvatarId: Types.MediaIdAvatar? = null,
    @Serializable(with = PluginBundleIdSer::class) override val pluginBundleId: Types.PluginBundleId,
    @Serializable(with = MetaIdFormSer::class) override val pluginConfigFormId: Types.MetaIdForm? = null,
    override val pluginFormKeys: List<@Serializable(with = MetaIdFormSer::class) Types.MetaIdForm>,
    override val pluginFormMap: Map<@Serializable(with = MetaIdFormSer::class) Types.MetaIdForm, DefnFormData>,
    @Serializable(with = PluginIdSer::class) override val pluginId: Types.PluginId,
    override val pluginName: String,
    override val pluginResourceMap: StudioEntPluginResourceMapData? = null,
    override val pluginVarKeys: List<@Serializable(with = MetaIdVarSer::class) Types.MetaIdVar>,
    override val pluginVarMap: Map<@Serializable(with = MetaIdVarSer::class) Types.MetaIdVar, StudioVarData>,
    override val pluginVersion: String,
    override val singleton: Boolean? = null
) : StudioEntPlugin
