// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnRenderingKind
import com.neome.api.meta.base.Types.EnumDefnShowBorderKind
import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind

interface DefnLayoutFormTemplate : DefnLayoutForm {
    val borderPositionSet: List<EnumDefnShowBorderKind>?
    val footer: DefnLayoutFormFooter?
    val header: DefnLayoutFormHeader?
    val paddingPositionSet: List<EnumDefnShowBorderKind>?
    val paddingSize: EnumDefnThemeDividerKind?
    val paperHeight: Long?
    val paperSize: EnumDefnRenderingKind?
    val paperWidth: Long?
    val watermark: DefnLayoutFormWatermark?
}
