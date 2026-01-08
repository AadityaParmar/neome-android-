// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoParagraph
import com.neome.api.meta.base.dto.DefnDtoText
import com.neome.api.meta.base.dto.DefnFieldLabel
import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldInfo : DefnFieldLabel
{
  val bottomPadding: EnumDefnThemeDividerKind?
  val bottomPaddingVar: EnumDefnThemeDividerKind?
  val defaultFieldId: MetaIdField?
  val defaultValue: String?
  val defaultVar: DefnDtoParagraph?
  val flexGrow: Boolean?
  val labelPatternVar: DefnDtoText?
  val leftPadding: EnumDefnThemeDividerKind?
  val leftPaddingVar: EnumDefnThemeDividerKind?
  val lineCount: Long?
  val lineCountFieldId: MetaIdField?
  val lineCountVar: Long?
  val rightPadding: EnumDefnThemeDividerKind?
  val rightPaddingVar: EnumDefnThemeDividerKind?
  val showBorder: Boolean?
  val showCloseButton: Boolean?
  val showLabel: Boolean?
  val topPadding: EnumDefnThemeDividerKind?
  val topPaddingVar: EnumDefnThemeDividerKind?
}