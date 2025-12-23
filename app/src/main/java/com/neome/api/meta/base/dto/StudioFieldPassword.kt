// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioFieldEditableText

open class StudioFieldPassword : StudioFieldEditableText()
{
  var maxCharCount: Number? = null
  var maxCharCountFieldId: MetaIdField? = null
  var maxCharCountVarId: MetaIdVar? = null
  var minCharCount: Number? = null
  var minCharCountFieldId: MetaIdField? = null
  var minCharCountVarId: MetaIdVar? = null
  var requireLowerCaseChar: Boolean? = null
  var requireNumericChar: Boolean? = null
  var requireSpecialChar: Boolean? = null
  var requireUpperCaseChar: Boolean? = null
  var securePassword: Boolean? = null
}