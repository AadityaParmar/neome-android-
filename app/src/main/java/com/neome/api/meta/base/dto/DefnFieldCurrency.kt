// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.CurrencyKey
import com.neome.api.meta.base.Types.MetaIdField

open class DefnFieldCurrency : DefnFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: CurrencyKey? = null
    var defaultVar: CurrencyKey? = null
}
