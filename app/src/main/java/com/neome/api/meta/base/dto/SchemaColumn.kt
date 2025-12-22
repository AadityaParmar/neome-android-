// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.ColumnPath
import com.neome.api.meta.base.Types.EnumSchemaColumnType
import com.neome.api.meta.base.Types.SymbolColumn

class SchemaColumn {
    val columnPath: ColumnPath
    val columnType: EnumSchemaColumnType
    val fieldQueryable: boolean
    val fieldSearchable: boolean
    val loggable: boolean
    val propertyMap: Record<string, string>
    val queryable: boolean
    val searchable: boolean
    val sortable: boolean
    val symbolColumn: SymbolColumn
}
