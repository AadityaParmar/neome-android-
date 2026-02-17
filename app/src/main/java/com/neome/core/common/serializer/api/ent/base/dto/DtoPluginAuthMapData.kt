package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoAuthMethodStatusMap
import com.neome.api.ent.base.dto.DtoPluginAuthMap
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.ent.base.dto.DtoAuthMethodStatusMapData
import com.neome.core.common.serializer.sysId.MetaIdPluginSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoPluginAuthMapData(
    override val pluginAuthMap: Map<@Serializable(with = MetaIdPluginSer::class) Types.MetaIdPlugin, DtoAuthMethodStatusMapData>
) : DtoPluginAuthMap
