// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.SymbolGrid

class SchemaGrid {
    val fieldMap: SchemaFieldMap
    val metaId: MetaIdGrid
    val parentSymbolGrid: SymbolGrid
    val symbolGrid: SymbolGrid
}
