// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioFieldLabel
import com.neome.api.meta.base.dto.StudioValueVarIdParagraph
import com.neome.api.meta.base.dto.StudioValueVarIdText

interface StudioFieldInfo : StudioFieldLabel
{
  val bottomPadding: EnumDefnThemeDividerKind?
  val bottomPaddingVarId: MetaIdVar?
  val defaultFieldId: MetaIdField?
  val defaultValue: String?
  val defaultVarId: StudioValueVarIdParagraph?
  val flexGrow: Boolean?
  val labelPatternVarId: StudioValueVarIdText?
  val leftPadding: EnumDefnThemeDividerKind?
  val leftPaddingVarId: MetaIdVar?
  val lineCount: Long?
  val lineCountFieldId: MetaIdField?
  val lineCountVarId: MetaIdVar?
  val rightPadding: EnumDefnThemeDividerKind?
  val rightPaddingVarId: MetaIdVar?
  val showBorder: Boolean?
  val showCloseButton: Boolean?
  val showLabel: Boolean?
  val topPadding: EnumDefnThemeDividerKind?
  val topPaddingVarId: MetaIdVar?
}