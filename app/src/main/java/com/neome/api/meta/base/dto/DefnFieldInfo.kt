// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoParagraph
import com.neome.api.meta.base.dto.DefnDtoText
import com.neome.api.meta.base.dto.DefnFieldLabel
import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind
import com.neome.api.meta.base.Types.MetaIdField

open class DefnFieldInfo : DefnFieldLabel()
{
  var bottomPadding: EnumDefnThemeDividerKind? = null
  var bottomPaddingVar: EnumDefnThemeDividerKind? = null
  var defaultFieldId: MetaIdField? = null
  var defaultValue: String? = null
  var defaultVar: DefnDtoParagraph? = null
  var flexGrow: Boolean? = null
  var labelPatternVar: DefnDtoText? = null
  var leftPadding: EnumDefnThemeDividerKind? = null
  var leftPaddingVar: EnumDefnThemeDividerKind? = null
  var lineCount: Number? = null
  var lineCountFieldId: MetaIdField? = null
  var lineCountVar: Number? = null
  var rightPadding: EnumDefnThemeDividerKind? = null
  var rightPaddingVar: EnumDefnThemeDividerKind? = null
  var showBorder: Boolean? = null
  var showCloseButton: Boolean? = null
  var showLabel: Boolean? = null
  var topPadding: EnumDefnThemeDividerKind? = null
  var topPaddingVar: EnumDefnThemeDividerKind? = null
}