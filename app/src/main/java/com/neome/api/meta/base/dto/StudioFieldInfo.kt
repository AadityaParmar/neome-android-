// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

open class StudioFieldInfo : StudioFieldLabel() {
    var bottomPadding: EnumDefnThemeDividerKind? = null
    var bottomPaddingVarId: MetaIdVar? = null
    var defaultFieldId: MetaIdField? = null
    var defaultValue: String? = null
    var defaultVarId: StudioValueVarIdParagraph? = null
    var flexGrow: Boolean? = null
    var labelPatternVarId: StudioValueVarIdText? = null
    var leftPadding: EnumDefnThemeDividerKind? = null
    var leftPaddingVarId: MetaIdVar? = null
    var lineCount: Number? = null
    var lineCountFieldId: MetaIdField? = null
    var lineCountVarId: MetaIdVar? = null
    var rightPadding: EnumDefnThemeDividerKind? = null
    var rightPaddingVarId: MetaIdVar? = null
    var showBorder: Boolean? = null
    var showCloseButton: Boolean? = null
    var showLabel: Boolean? = null
    var topPadding: EnumDefnThemeDividerKind? = null
    var topPaddingVarId: MetaIdVar? = null
}
