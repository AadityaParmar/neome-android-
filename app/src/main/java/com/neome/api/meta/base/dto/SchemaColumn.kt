// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import kotlin.properties.Delegates
import com.neome.api.meta.base.Types.ColumnPath
import com.neome.api.meta.base.Types.EnumSchemaColumnType
import java.util.Map
import com.neome.api.meta.base.Types.SymbolColumn

open class SchemaColumn {
    lateinit var columnPath: ColumnPath
    lateinit var columnType: EnumSchemaColumnType
    var fieldQueryable: Boolean by Delegates.notNull<Boolean>()
    var fieldSearchable: Boolean by Delegates.notNull<Boolean>()
    var loggable: Boolean by Delegates.notNull<Boolean>()
    lateinit var propertyMap: Map<String, String>
    var queryable: Boolean by Delegates.notNull<Boolean>()
    var searchable: Boolean by Delegates.notNull<Boolean>()
    var sortable: Boolean by Delegates.notNull<Boolean>()
    lateinit var symbolColumn: SymbolColumn
}
