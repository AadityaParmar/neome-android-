// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField

open class DefnFieldColor : DefnFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: String? = null
}
