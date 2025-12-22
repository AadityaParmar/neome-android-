// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioFieldEditableText

class StudioFieldPassword : StudioFieldEditableText() {
    var maxCharCount: number? = null
    var maxCharCountFieldId: MetaIdField? = null
    var maxCharCountVarId: MetaIdVar? = null
    var minCharCount: number? = null
    var minCharCountFieldId: MetaIdField? = null
    var minCharCountVarId: MetaIdVar? = null
    var requireLowerCaseChar: boolean? = null
    var requireNumericChar: boolean? = null
    var requireSpecialChar: boolean? = null
    var requireUpperCaseChar: boolean? = null
    var securePassword: boolean? = null
}
