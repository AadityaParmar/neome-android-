// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditableText
import com.neome.api.meta.base.Types.MetaIdField

open class DefnFieldPassword : DefnFieldEditableText()
{
  var maxCharCount: Number? = null
  var maxCharCountFieldId: MetaIdField? = null
  var maxCharCountVar: Number? = null
  var minCharCount: Number? = null
  var minCharCountFieldId: MetaIdField? = null
  var minCharCountVar: Number? = null
  var requireLowerCaseChar: Boolean? = null
  var requireNumericChar: Boolean? = null
  var requireSpecialChar: Boolean? = null
  var requireUpperCaseChar: Boolean? = null
  var securePassword: Boolean? = null
}