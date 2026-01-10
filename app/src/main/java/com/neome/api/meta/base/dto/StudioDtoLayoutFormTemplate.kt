// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnRenderingKind
import com.neome.api.meta.base.Types.EnumDefnShowBorderKind
import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind

interface StudioDtoLayoutFormTemplate : StudioDtoLayoutForm {
    val borderPositionSet: List<EnumDefnShowBorderKind>?
    val footer: StudioDtoLayoutFormFooter?
    val header: StudioDtoLayoutFormHeader?
    val paddingPositionSet: List<EnumDefnShowBorderKind>?
    val paddingSize: EnumDefnThemeDividerKind?
    val paperHeight: Long?
    val paperSize: EnumDefnRenderingKind?
    val paperWidth: Long?
    val watermark: StudioDtoLayoutFormWatermark?
}
