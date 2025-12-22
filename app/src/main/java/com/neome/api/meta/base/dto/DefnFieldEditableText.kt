// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField

class DefnFieldEditableText : DefnFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: string? = null
    var defaultVar: DefnDtoText? = null
}
