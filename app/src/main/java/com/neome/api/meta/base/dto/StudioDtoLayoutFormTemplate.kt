// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnRenderingKind
import com.neome.api.meta.base.Types.EnumDefnShowBorderKind
import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind
import com.neome.api.meta.base.dto.StudioDtoLayoutForm
import com.neome.api.meta.base.dto.StudioDtoLayoutFormFooter
import com.neome.api.meta.base.dto.StudioDtoLayoutFormHeader
import com.neome.api.meta.base.dto.StudioDtoLayoutFormWatermark

interface StudioDtoLayoutFormTemplate : StudioDtoLayoutForm
{
  val borderPositionSet: Array<EnumDefnShowBorderKind>?
  val footer: StudioDtoLayoutFormFooter?
  val header: StudioDtoLayoutFormHeader?
  val paddingPositionSet: Array<EnumDefnShowBorderKind>?
  val paddingSize: EnumDefnThemeDividerKind?
  val paperHeight: Long?
  val paperSize: EnumDefnRenderingKind?
  val paperWidth: Long?
  val watermark: StudioDtoLayoutFormWatermark?
}