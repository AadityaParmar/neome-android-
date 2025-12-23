// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.AnyEmailId
import com.neome.api.meta.base.Types.MetaIdField

open class DefnFieldEmail : DefnFieldEditable() {
    var autoPickSelf: Boolean? = null
    var defaultFieldId: MetaIdField? = null
    var defaultValue: AnyEmailId? = null
    var defaultVar: AnyEmailId? = null
    var invalidDomainSetVar: Array<String>? = null
    var validDomainSetVar: Array<String>? = null
}
