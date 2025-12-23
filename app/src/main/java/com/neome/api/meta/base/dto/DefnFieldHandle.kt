// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField

open class DefnFieldHandle : DefnFieldEditable() {
    var autoPickSelf: Boolean? = null
    var defaultFieldId: MetaIdField? = null
    var defaultValue: String? = null
    var defaultVar: String? = null
    var invalidDomainSetVar: Array<String>? = null
    var invalidMobileCountryCodeSetVar: Array<String>? = null
    var validDomainSetVar: Array<String>? = null
    var validMobileCountryCodeSetVar: Array<String>? = null
}
