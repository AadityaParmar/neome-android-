// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnRenderingKind
import com.neome.api.meta.base.Types.EnumDefnShowBorderKind
import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind

open class StudioDtoLayoutFormTemplate : StudioDtoLayoutForm() {
    var borderPositionSet: Array<EnumDefnShowBorderKind>? = null
    var footer: StudioDtoLayoutFormFooter? = null
    var header: StudioDtoLayoutFormHeader? = null
    var paddingPositionSet: Array<EnumDefnShowBorderKind>? = null
    var paddingSize: EnumDefnThemeDividerKind? = null
    var paperHeight: Number? = null
    var paperSize: EnumDefnRenderingKind? = null
    var paperWidth: Number? = null
    var watermark: StudioDtoLayoutFormWatermark? = null
}
