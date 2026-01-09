package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntDeployPlugin
import com.neome.api.meta.base.dto.StudioEntDeployPluginMap
import com.neome.core.common.serializer.sysId.AdminIdSer
import com.neome.core.common.serializer.sysId.MetaIdPluginSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntDeployPluginMapData(
    override val keys: Array<@Serializable(with = MetaIdPluginSer::class) Types.MetaIdPlugin>,
    override val map: Map<@Serializable(with = MetaIdPluginSer::class) Types.MetaIdPlugin, StudioEntDeployPlugin>,
    @Serializable(with = AdminIdSer::class) override val singletonPluginsAdminId: Types.AdminId? = null
) : StudioEntDeployPluginMap
