package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioPluginApi
import com.neome.api.meta.base.dto.StudioPluginApiMap
import com.neome.core.common.serializer.api.meta.base.dto.StudioPluginApiData
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.PluginApiIdSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioPluginApiMapData(
    override val keys: List<@Serializable(with = PluginApiIdSer::class) Types.PluginApiId>,
    override val map: Map<@Serializable(with = PluginApiIdSer::class) Types.PluginApiId, StudioPluginApiData>,
    @Serializable(with = MetaIdFormSer::class) override val pluginConfigFormId: Types.MetaIdForm? = null
) : StudioPluginApiMap
