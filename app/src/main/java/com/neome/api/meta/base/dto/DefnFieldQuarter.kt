// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.EnumDefnQuarter
import com.neome.api.meta.base.Types.MetaIdField

class DefnFieldQuarter : DefnFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: EnumDefnQuarter? = null
    var defaultVar: EnumDefnQuarter? = null
}
