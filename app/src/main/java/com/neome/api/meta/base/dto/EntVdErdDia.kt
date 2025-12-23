// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVdErdDia
import java.util.Map

open class EntVdErdDia : EntVdDia() {
    var entityMap: Map<MetaIdSpreadsheet, EntVdErdEntity>? = null
    var label: String? = null
    lateinit var metaId: MetaIdVdErdDia
    lateinit var name: Symbol
    var refMap: Map<MetaIdField, EntVdErdRef>? = null
}
