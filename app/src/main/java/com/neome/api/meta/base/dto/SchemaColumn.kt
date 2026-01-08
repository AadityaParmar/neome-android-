// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.ColumnPath
import com.neome.api.meta.base.Types.EnumSchemaColumnType
import com.neome.api.meta.base.Types.SymbolColumn

interface SchemaColumn
{
  val columnPath: ColumnPath
  val columnType: EnumSchemaColumnType
  val fieldQueryable: Boolean
  val fieldSearchable: Boolean
  val loggable: Boolean
  val propertyMap: Map<String, String>
  val queryable: Boolean
  val searchable: Boolean
  val sortable: Boolean
  val symbolColumn: SymbolColumn
}