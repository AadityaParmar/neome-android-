// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioFieldEditable
import com.neome.api.meta.base.dto.StudioValueVarIdParagraph

interface StudioFieldParagraph : StudioFieldEditable
{
  val defaultFieldId: MetaIdField?
  val defaultValue: String?
  val defaultVarId: StudioValueVarIdParagraph?
  val flexHeight: Boolean?
  val lineCount: Long?
  val lineCountFieldId: MetaIdField?
  val lineCountVarId: MetaIdVar?
  val maxCharCount: Long?
  val maxCharCountFieldId: MetaIdField?
  val maxCharCountVarId: MetaIdVar?
  val minCharCount: Long?
  val minCharCountFieldId: MetaIdField?
  val minCharCountVarId: MetaIdVar?
}