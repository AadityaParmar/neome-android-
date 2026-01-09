package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.SchemaGrid
import com.neome.api.meta.base.dto.SchemaGridMap
import com.neome.core.common.serializer.sysId.MetaIdGridSer
import kotlinx.serialization.Serializable


@Serializable
data class SchemaGridMapData(
    override val map: Map<@Serializable(with = MetaIdGridSer::class) Types.MetaIdGrid, SchemaGrid>
) : SchemaGridMap
