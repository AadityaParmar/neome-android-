// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField

open class DefnFieldEditableText : DefnFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: String? = null
    var defaultVar: DefnDtoText? = null
}
