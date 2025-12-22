// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnRenderingKind
import com.neome.api.meta.base.Types.EnumDefnShowBorderKind
import com.neome.api.meta.base.Types.EnumDefnShowBorderRadiusKind
import com.neome.api.meta.base.Types.EnumDefnThemeDirection
import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdVar

class StudioDtoLayoutFormContent : StudioDtoLayoutForm() {
    var allowToSwitchLayoutIdSet: MetaIdLayoutForm[]? = null
    var backgroundColor: StudioDtoColor? = null
    var backgroundColorVarId: MetaIdVar? = null
    var borderColor: StudioDtoColor? = null
    var borderColorVarId: MetaIdVar? = null
    var borderPositionSet: EnumDefnShowBorderKind[]? = null
    var borderRadiusSet: EnumDefnShowBorderRadiusKind[]? = null
    var borderRadiusSize: EnumDefnThemeDividerKind? = null
    var direction: EnumDefnThemeDirection? = null
    var displayLabel: string? = null
    var end: StudioDtoLayoutFormContentItem? = null
    var flexCenter: StudioDtoLayoutFormContentItem? = null
    var paddingPositionSet: EnumDefnShowBorderKind[]? = null
    var paddingSize: EnumDefnThemeDividerKind? = null
    var renderingMode: EnumDefnRenderingKind? = null
    var rootLayout: boolean? = null
    var start: StudioDtoLayoutFormContentItem? = null
}
