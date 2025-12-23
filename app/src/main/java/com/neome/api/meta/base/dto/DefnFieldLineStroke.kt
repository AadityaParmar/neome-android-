// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemeStroke
import com.neome.api.meta.base.Types.MetaIdField

open class DefnFieldLineStroke : DefnFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: EnumDefnThemeStroke? = null
    var defaultVar: EnumDefnThemeStroke? = null
}
