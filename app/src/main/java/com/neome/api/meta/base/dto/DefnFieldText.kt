// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField

class DefnFieldText : DefnFieldEditableText() {
    var maxCharCount: number? = null
    var maxCharCountFieldId: MetaIdField? = null
    var maxCharCountVar: number? = null
    var minCharCount: number? = null
    var minCharCountFieldId: MetaIdField? = null
    var minCharCountVar: number? = null
    var validationPattern: DefnDtoTextValidationPattern? = null
}
