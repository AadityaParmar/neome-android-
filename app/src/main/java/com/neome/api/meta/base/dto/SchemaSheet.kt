// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.SymbolGrid

open class SchemaSheet {
    lateinit var fieldMap: SchemaFieldMap
    lateinit var formSymbol: SymbolGrid
    lateinit var gridMap: SchemaGridMap
    lateinit var metaId: MetaIdForm
}
