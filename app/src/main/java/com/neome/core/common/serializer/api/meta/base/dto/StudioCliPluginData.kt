package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnPluginMode
import com.neome.api.meta.base.dto.StudioCliPlugin
import com.neome.api.meta.base.dto.StudioFormMap
import com.neome.api.meta.base.dto.StudioModuleMap
import com.neome.api.meta.base.dto.StudioPlugin
import com.neome.api.meta.base.dto.StudioPluginApiMap
import com.neome.api.meta.base.dto.StudioPluginDeploy
import com.neome.api.meta.base.dto.StudioPluginDetails
import com.neome.api.meta.base.dto.StudioPluginResourceMap
import com.neome.api.meta.base.dto.StudioPluginTrash
import com.neome.api.meta.base.dto.StudioStoreItemDetailMap
import com.neome.api.meta.base.dto.StudioVarMap
import com.neome.core.common.serializer.sysId.AdminIdSer
import com.neome.core.common.serializer.sysId.PluginBundleIdSer
import com.neome.core.common.serializer.sysId.PluginIdSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioCliPluginData(
    override val apiMap: StudioPluginApiMap,
    @Serializable(with = AdminIdSer::class) override val createdBy: Types.AdminId? = null,
    override val creationTime: String? = null,
    override val deploy: StudioPluginDeploy,
    override val deprecate: Boolean? = null,
    override val details: StudioPluginDetails,
    override val formMap: StudioFormMap,
    @Serializable(with = AdminIdSer::class) override val lastUpdateBy: Types.AdminId? = null,
    override val lastUpdateTime: String? = null,
    @Serializable(with = PluginIdSer::class) override val metaId: Types.PluginId,
    override val mode: EnumDefnPluginMode,
    override val moduleMap: StudioModuleMap,
    override val resourceMap: StudioPluginResourceMap? = null,
    override val storeItemDetailMap: StudioStoreItemDetailMap? = null,
    override val trash: StudioPluginTrash? = null,
    override val varMap: StudioVarMap,
    override val version: String? = null,
    @Serializable(with = PluginBundleIdSer::class) override val pluginBundleId: Types.PluginBundleId? = null
) : StudioCliPlugin
