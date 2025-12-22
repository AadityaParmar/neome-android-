// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

class StudioFieldInfo : StudioFieldLabel() {
    var bottomPadding: EnumDefnThemeDividerKind? = null
    var bottomPaddingVarId: MetaIdVar? = null
    var defaultFieldId: MetaIdField? = null
    var defaultValue: string? = null
    var defaultVarId: StudioValueVarIdParagraph? = null
    var flexGrow: boolean? = null
    var labelPatternVarId: StudioValueVarIdText? = null
    var leftPadding: EnumDefnThemeDividerKind? = null
    var leftPaddingVarId: MetaIdVar? = null
    var lineCount: number? = null
    var lineCountFieldId: MetaIdField? = null
    var lineCountVarId: MetaIdVar? = null
    var rightPadding: EnumDefnThemeDividerKind? = null
    var rightPaddingVarId: MetaIdVar? = null
    var showBorder: boolean? = null
    var showCloseButton: boolean? = null
    var showLabel: boolean? = null
    var topPadding: EnumDefnThemeDividerKind? = null
    var topPaddingVarId: MetaIdVar? = null
}
