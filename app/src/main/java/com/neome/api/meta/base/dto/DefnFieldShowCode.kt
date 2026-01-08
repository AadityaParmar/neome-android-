// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoParagraph
import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.EnumDefnCodeType
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldShowCode : DefnFieldEditable
{
  val codeType: EnumDefnCodeType?
  val defaultFieldId: MetaIdField?
  val defaultValue: String?
  val defaultVar: DefnDtoParagraph?
  val showLabel: Boolean?
  val showLabelFieldId: MetaIdField?
  val showLabelVar: Boolean?
}