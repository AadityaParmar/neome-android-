// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField

open class DefnFieldMobileNumber : DefnFieldEditable() {
    var autoPickSelf: Boolean? = null
    var defaultFieldId: MetaIdField? = null
    var defaultValue: String? = null
    var defaultVar: String? = null
    var invalidCountryCodeSetVar: Array<String>? = null
    var validCountryCodeSetVar: Array<String>? = null
}
