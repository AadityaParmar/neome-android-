// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCompType
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.dto.SchemaColumn
import com.neome.api.meta.base.Types.SymbolColumn

open class SchemaColumnMap
{
  lateinit var columnMap: Map<SymbolColumn, SchemaColumn>
  lateinit var fieldId: MetaIdField
  lateinit var fieldType: EnumDefnCompType
}