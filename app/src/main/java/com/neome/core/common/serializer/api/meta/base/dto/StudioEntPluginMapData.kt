package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntPlugin
import com.neome.api.meta.base.dto.StudioEntPluginMap
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntPluginData
import com.neome.core.common.serializer.sysId.MetaIdPluginSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntPluginMapData(
    override val keys: List<@Serializable(with = MetaIdPluginSer::class) Types.MetaIdPlugin>,
    override val map: Map<@Serializable(with = MetaIdPluginSer::class) Types.MetaIdPlugin, StudioEntPluginData>
) : StudioEntPluginMap
