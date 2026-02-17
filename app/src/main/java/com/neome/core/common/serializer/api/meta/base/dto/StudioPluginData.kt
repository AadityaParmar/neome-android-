package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnPluginMode
import com.neome.api.meta.base.dto.StudioDeployUnit
import com.neome.api.meta.base.dto.StudioFormMap
import com.neome.api.meta.base.dto.StudioModuleMap
import com.neome.api.meta.base.dto.StudioPlugin
import com.neome.api.meta.base.dto.StudioPluginApiMap
import com.neome.api.meta.base.dto.StudioPluginAuthMap
import com.neome.api.meta.base.dto.StudioPluginDeploy
import com.neome.api.meta.base.dto.StudioPluginDetails
import com.neome.api.meta.base.dto.StudioPluginResourceMap
import com.neome.api.meta.base.dto.StudioPluginTrash
import com.neome.api.meta.base.dto.StudioStoreItemDetailMap
import com.neome.api.meta.base.dto.StudioVarMap
import com.neome.core.common.serializer.api.meta.base.dto.StudioFormMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioModuleMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioPluginApiMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioPluginAuthMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioPluginDeployData
import com.neome.core.common.serializer.api.meta.base.dto.StudioPluginDetailsData
import com.neome.core.common.serializer.api.meta.base.dto.StudioPluginResourceMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioPluginTrashData
import com.neome.core.common.serializer.api.meta.base.dto.StudioStoreItemDetailMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioVarMapData
import com.neome.core.common.serializer.sysId.AdminIdSer
import com.neome.core.common.serializer.sysId.PluginIdSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioPluginData(
    override val apiMap: StudioPluginApiMapData,
    override val authMap: StudioPluginAuthMapData? = null,
    @Serializable(with = AdminIdSer::class) override val createdBy: Types.AdminId? = null,
    override val creationTime: String? = null,
    override val deploy: StudioPluginDeployData,
    override val deprecate: Boolean? = null,
    override val details: StudioPluginDetailsData,
    override val formMap: StudioFormMapData,
    @Serializable(with = AdminIdSer::class) override val lastUpdateBy: Types.AdminId? = null,
    override val lastUpdateTime: String? = null,
    @Serializable(with = PluginIdSer::class) override val metaId: Types.PluginId,
    override val mode: EnumDefnPluginMode,
    override val moduleMap: StudioModuleMapData,
    override val resourceMap: StudioPluginResourceMapData? = null,
    override val storeItemDetailMap: StudioStoreItemDetailMapData? = null,
    override val trash: StudioPluginTrashData? = null,
    override val varMap: StudioVarMapData,
    override val version: String? = null
) : StudioPlugin
