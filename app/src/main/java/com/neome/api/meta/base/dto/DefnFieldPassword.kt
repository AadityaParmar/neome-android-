// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditableText
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldPassword : DefnFieldEditableText
{
  val maxCharCount: Long?
  val maxCharCountFieldId: MetaIdField?
  val maxCharCountVar: Long?
  val minCharCount: Long?
  val minCharCountFieldId: MetaIdField?
  val minCharCountVar: Long?
  val requireLowerCaseChar: Boolean?
  val requireNumericChar: Boolean?
  val requireSpecialChar: Boolean?
  val requireUpperCaseChar: Boolean?
  val securePassword: Boolean?
}