package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.dto.SchemaColumn
import com.neome.api.meta.base.dto.SchemaColumnMap
import com.neome.core.common.serializer.api.meta.base.dto.SchemaColumnData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.SymbolColumnSer
import kotlinx.serialization.Serializable


@Serializable
data class SchemaColumnMapData(
    override val columnMap: Map<@Serializable(with = SymbolColumnSer::class) Types.SymbolColumn, SchemaColumnData>,
    @Serializable(with = MetaIdFieldSer::class) override val fieldId: Types.MetaIdField,
    override val fieldType: EnumDefnCompType
) : SchemaColumnMap
