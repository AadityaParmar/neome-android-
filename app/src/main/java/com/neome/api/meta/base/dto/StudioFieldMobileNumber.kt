// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

open class StudioFieldMobileNumber : StudioFieldEditable() {
    var autoPickSelf: Boolean? = null
    var defaultFieldId: MetaIdField? = null
    var defaultValue: String? = null
    var defaultVarId: MetaIdVar? = null
    var invalidCountryCodeSetVarId: MetaIdVar? = null
    var validCountryCodeSetVarId: MetaIdVar? = null
}
