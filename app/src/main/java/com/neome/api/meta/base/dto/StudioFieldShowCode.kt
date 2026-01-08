// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCodeType
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioFieldEditable
import com.neome.api.meta.base.dto.StudioValueVarIdParagraph

interface StudioFieldShowCode : StudioFieldEditable
{
  val codeType: EnumDefnCodeType?
  val defaultFieldId: MetaIdField?
  val defaultValue: String?
  val defaultVarId: StudioValueVarIdParagraph?
  val showLabel: Boolean?
  val showLabelFieldId: MetaIdField?
  val showLabelVarId: MetaIdVar?
}