// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField

class DefnFieldHandle : DefnFieldEditable() {
    var autoPickSelf: boolean? = null
    var defaultFieldId: MetaIdField? = null
    var defaultValue: string? = null
    var defaultVar: string? = null
    var invalidDomainSetVar: string[]? = null
    var invalidMobileCountryCodeSetVar: string[]? = null
    var validDomainSetVar: string[]? = null
    var validMobileCountryCodeSetVar: string[]? = null
}
