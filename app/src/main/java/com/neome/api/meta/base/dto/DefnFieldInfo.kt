// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind
import com.neome.api.meta.base.Types.MetaIdField

class DefnFieldInfo : DefnFieldLabel() {
    var bottomPadding: EnumDefnThemeDividerKind? = null
    var bottomPaddingVar: EnumDefnThemeDividerKind? = null
    var defaultFieldId: MetaIdField? = null
    var defaultValue: string? = null
    var defaultVar: DefnDtoParagraph? = null
    var flexGrow: boolean? = null
    var labelPatternVar: DefnDtoText? = null
    var leftPadding: EnumDefnThemeDividerKind? = null
    var leftPaddingVar: EnumDefnThemeDividerKind? = null
    var lineCount: number? = null
    var lineCountFieldId: MetaIdField? = null
    var lineCountVar: number? = null
    var rightPadding: EnumDefnThemeDividerKind? = null
    var rightPaddingVar: EnumDefnThemeDividerKind? = null
    var showBorder: boolean? = null
    var showCloseButton: boolean? = null
    var showLabel: boolean? = null
    var topPadding: EnumDefnThemeDividerKind? = null
    var topPaddingVar: EnumDefnThemeDividerKind? = null
}
