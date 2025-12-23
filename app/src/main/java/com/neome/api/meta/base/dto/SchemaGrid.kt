// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.dto.SchemaFieldMap
import com.neome.api.meta.base.Types.SymbolGrid

open class SchemaGrid
{
  lateinit var fieldMap: SchemaFieldMap
  lateinit var metaId: MetaIdGrid
  lateinit var parentSymbolGrid: SymbolGrid
  lateinit var symbolGrid: SymbolGrid
}