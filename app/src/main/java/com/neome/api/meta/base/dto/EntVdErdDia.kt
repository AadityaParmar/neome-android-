// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVdErdDia

class EntVdErdDia : EntVdDia() {
    var entityMap: Record<MetaIdSpreadsheet, EntVdErdEntity>? = null
    var label: string? = null
    val metaId: MetaIdVdErdDia
    val name: Symbol
    var refMap: Record<MetaIdField, EntVdErdRef>? = null
}
