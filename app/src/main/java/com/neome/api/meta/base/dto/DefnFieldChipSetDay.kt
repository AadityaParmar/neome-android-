// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnDay
import com.neome.api.meta.base.Types.MetaIdField

class DefnFieldChipSetDay : DefnFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: EnumDefnDay[]? = null
    var defaultVar: EnumDefnDay[]? = null
}
