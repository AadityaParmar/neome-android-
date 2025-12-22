// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnRenderingKind
import com.neome.api.meta.base.Types.EnumDefnShowBorderKind
import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind

class DefnLayoutFormTemplate : DefnLayoutForm() {
    var borderPositionSet: EnumDefnShowBorderKind[]? = null
    var footer: DefnLayoutFormFooter? = null
    var header: DefnLayoutFormHeader? = null
    var paddingPositionSet: EnumDefnShowBorderKind[]? = null
    var paddingSize: EnumDefnThemeDividerKind? = null
    var paperHeight: number? = null
    var paperSize: EnumDefnRenderingKind? = null
    var paperWidth: number? = null
    var watermark: DefnLayoutFormWatermark? = null
}
