// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.SymbolColumn

class SchemaColumnMap {
    val columnMap: Record<SymbolColumn, SchemaColumn>
    val fieldId: MetaIdField
    val fieldType: EnumDefnCompType
}
