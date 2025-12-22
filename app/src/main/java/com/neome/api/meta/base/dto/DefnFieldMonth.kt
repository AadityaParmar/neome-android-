// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnMonth
import com.neome.api.meta.base.Types.MetaIdField

class DefnFieldMonth : DefnFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: EnumDefnMonth? = null
    var defaultVar: EnumDefnMonth? = null
}
