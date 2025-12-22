// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.AnyEmailId
import com.neome.api.meta.base.Types.MetaIdField

class DefnFieldEmail : DefnFieldEditable() {
    var autoPickSelf: boolean? = null
    var defaultFieldId: MetaIdField? = null
    var defaultValue: AnyEmailId? = null
    var defaultVar: AnyEmailId? = null
    var invalidDomainSetVar: string[]? = null
    var validDomainSetVar: string[]? = null
}
