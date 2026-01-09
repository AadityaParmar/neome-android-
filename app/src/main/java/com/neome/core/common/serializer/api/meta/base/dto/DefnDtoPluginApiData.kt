package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnDtoPluginApi
import com.neome.core.common.serializer.sysId.MetaIdPluginSer
import com.neome.core.common.serializer.sysId.PluginApiIdSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnDtoPluginApiData(
    @Serializable(with = MetaIdPluginSer::class) override val metaIdPlugin: Types.MetaIdPlugin,
    @Serializable(with = PluginApiIdSer::class) override val pluginApiId: Types.PluginApiId
) : DefnDtoPluginApi
