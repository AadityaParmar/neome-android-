package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoPluginApi
import com.neome.core.common.serializer.sysId.MetaIdPluginSer
import com.neome.core.common.serializer.sysId.PluginApiIdSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoPluginApiData(
    @Serializable(with = MetaIdPluginSer::class) override val metaIdPlugin: Types.MetaIdPlugin? = null,
    @Serializable(with = PluginApiIdSer::class) override val pluginApiId: Types.PluginApiId? = null
) : StudioDtoPluginApi
