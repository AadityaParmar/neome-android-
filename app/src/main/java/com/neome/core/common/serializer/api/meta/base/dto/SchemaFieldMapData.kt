package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.SchemaColumnMap
import com.neome.api.meta.base.dto.SchemaFieldMap
import com.neome.core.common.serializer.api.meta.base.dto.SchemaColumnMapData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import kotlinx.serialization.Serializable


@Serializable
data class SchemaFieldMapData(
    override val map: Map<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField, SchemaColumnMapData>
) : SchemaFieldMap
