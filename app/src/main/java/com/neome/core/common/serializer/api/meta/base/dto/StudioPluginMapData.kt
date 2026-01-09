package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioPlugin
import com.neome.api.meta.base.dto.StudioPluginMap
import com.neome.core.common.serializer.sysId.PluginIdSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioPluginMapData(
    override val keys: Array<@Serializable(with = PluginIdSer::class) Types.PluginId>,
    override val map: Map<@Serializable(with = PluginIdSer::class) Types.PluginId, StudioPlugin>
) : StudioPluginMap
