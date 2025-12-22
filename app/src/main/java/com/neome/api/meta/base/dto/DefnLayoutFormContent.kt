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

class DefnLayoutFormContent : DefnLayoutForm() {
    var allowToSwitchLayoutIdSet: MetaIdLayoutForm[]? = null
    var backgroundColor: DefnDtoColor? = null
    var backgroundColorVar: DefnDtoColor? = null
    var borderColor: DefnDtoColor? = null
    var borderColorVar: DefnDtoColor? = null
    var borderPositionSet: EnumDefnShowBorderKind[]? = null
    var borderRadiusSet: EnumDefnShowBorderRadiusKind[]? = null
    var borderRadiusSize: EnumDefnThemeDividerKind? = null
    var direction: EnumDefnThemeDirection? = null
    var displayLabel: string? = null
    var end: DefnDtoLayoutFormContentItem? = null
    var flexCenter: DefnDtoLayoutFormContentItem? = null
    var paddingPositionSet: EnumDefnShowBorderKind[]? = null
    var paddingSize: EnumDefnThemeDividerKind? = null
    var renderingMode: EnumDefnRenderingKind? = null
    var start: DefnDtoLayoutFormContentItem? = null
}
