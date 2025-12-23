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

open class StudioDtoLayoutFormContent : StudioDtoLayoutForm() {
    var allowToSwitchLayoutIdSet: Array<MetaIdLayoutForm>? = null
    var backgroundColor: StudioDtoColor? = null
    var backgroundColorVarId: MetaIdVar? = null
    var borderColor: StudioDtoColor? = null
    var borderColorVarId: MetaIdVar? = null
    var borderPositionSet: Array<EnumDefnShowBorderKind>? = null
    var borderRadiusSet: Array<EnumDefnShowBorderRadiusKind>? = null
    var borderRadiusSize: EnumDefnThemeDividerKind? = null
    var direction: EnumDefnThemeDirection? = null
    var displayLabel: String? = null
    var end: StudioDtoLayoutFormContentItem? = null
    var flexCenter: StudioDtoLayoutFormContentItem? = null
    var paddingPositionSet: Array<EnumDefnShowBorderKind>? = null
    var paddingSize: EnumDefnThemeDividerKind? = null
    var renderingMode: EnumDefnRenderingKind? = null
    var rootLayout: Boolean? = null
    var start: StudioDtoLayoutFormContentItem? = null
}
