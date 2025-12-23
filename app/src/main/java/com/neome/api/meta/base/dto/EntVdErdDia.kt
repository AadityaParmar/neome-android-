// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdDia
import com.neome.api.meta.base.dto.EntVdErdEntity
import com.neome.api.meta.base.dto.EntVdErdRef
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVdErdDia
import com.neome.api.meta.base.Symbol

open class EntVdErdDia : EntVdDia()
{
  var entityMap: Map<MetaIdSpreadsheet, EntVdErdEntity>? = null
  var label: String? = null
  lateinit var metaId: MetaIdVdErdDia
  lateinit var name: Symbol
  var refMap: Map<MetaIdField, EntVdErdRef>? = null
}