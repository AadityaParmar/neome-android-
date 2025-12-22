// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.SymbolGrid

class SchemaSheet {
    val fieldMap: SchemaFieldMap
    val formSymbol: SymbolGrid
    val gridMap: SchemaGridMap
    val metaId: MetaIdForm
}
