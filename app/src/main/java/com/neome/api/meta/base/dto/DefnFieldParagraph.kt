// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoParagraph
import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldParagraph : DefnFieldEditable
{
  val defaultFieldId: MetaIdField?
  val defaultValue: String?
  val defaultVar: DefnDtoParagraph?
  val flexHeight: Boolean?
  val lineCount: Long?
  val lineCountFieldId: MetaIdField?
  val lineCountVar: Long?
  val maxCharCount: Long?
  val maxCharCountFieldId: MetaIdField?
  val maxCharCountVar: Long?
  val minCharCount: Long?
  val minCharCountFieldId: MetaIdField?
  val minCharCountVar: Long?
}