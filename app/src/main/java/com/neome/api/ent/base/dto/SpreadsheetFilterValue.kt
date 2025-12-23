// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.Types.EnumFieldFilterValueType
import com.neome.api.meta.base.Types.MetaIdComp

open class SpreadsheetFilterValue {
    lateinit var metaIdField: MetaIdComp
    lateinit var type: EnumFieldFilterValueType
}
