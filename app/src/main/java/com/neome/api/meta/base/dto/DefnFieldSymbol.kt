// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.MetaIdField

class DefnFieldSymbol : DefnFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: Symbol? = null
    var defaultVar: Symbol? = null
}
