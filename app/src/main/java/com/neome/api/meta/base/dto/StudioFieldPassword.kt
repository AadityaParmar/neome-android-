// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioFieldEditableText

interface StudioFieldPassword : StudioFieldEditableText
{
  val maxCharCount: Long?
  val maxCharCountFieldId: MetaIdField?
  val maxCharCountVarId: MetaIdVar?
  val minCharCount: Long?
  val minCharCountFieldId: MetaIdField?
  val minCharCountVarId: MetaIdVar?
  val requireLowerCaseChar: Boolean?
  val requireNumericChar: Boolean?
  val requireSpecialChar: Boolean?
  val requireUpperCaseChar: Boolean?
  val securePassword: Boolean?
}