// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

open class StudioFieldText : StudioFieldEditableText() {
    var maxCharCount: Number? = null
    var maxCharCountFieldId: MetaIdField? = null
    var maxCharCountVarId: MetaIdVar? = null
    var minCharCount: Number? = null
    var minCharCountFieldId: MetaIdField? = null
    var minCharCountVarId: MetaIdVar? = null
    var validationPattern: StudioDtoTextValidationPattern? = null
}
