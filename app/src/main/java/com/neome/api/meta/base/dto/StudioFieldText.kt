// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioDtoTextValidationPattern
import com.neome.api.meta.base.dto.StudioFieldEditableText

interface StudioFieldText : StudioFieldEditableText
{
  val maxCharCount: Long?
  val maxCharCountFieldId: MetaIdField?
  val maxCharCountVarId: MetaIdVar?
  val minCharCount: Long?
  val minCharCountFieldId: MetaIdField?
  val minCharCountVarId: MetaIdVar?
  val validationPattern: StudioDtoTextValidationPattern?
}