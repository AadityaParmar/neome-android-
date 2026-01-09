package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumSchemaColumnType
import com.neome.api.meta.base.dto.SchemaColumn
import com.neome.core.common.serializer.sysId.ColumnPathSer
import com.neome.core.common.serializer.sysId.SymbolColumnSer
import kotlinx.serialization.Serializable


@Serializable
data class SchemaColumnData(
    @Serializable(with = ColumnPathSer::class) override val columnPath: Types.ColumnPath,
    override val columnType: EnumSchemaColumnType,
    override val fieldQueryable: Boolean,
    override val fieldSearchable: Boolean,
    override val loggable: Boolean,
    override val propertyMap: Map<String, String>,
    override val queryable: Boolean,
    override val searchable: Boolean,
    override val sortable: Boolean,
    @Serializable(with = SymbolColumnSer::class) override val symbolColumn: Types.SymbolColumn
) : SchemaColumn
