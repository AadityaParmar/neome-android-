// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnLayoutForm
import com.neome.api.meta.base.dto.DefnLayoutFormFooter
import com.neome.api.meta.base.dto.DefnLayoutFormHeader
import com.neome.api.meta.base.dto.DefnLayoutFormWatermark
import com.neome.api.meta.base.Types.EnumDefnRenderingKind
import com.neome.api.meta.base.Types.EnumDefnShowBorderKind
import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind

interface DefnLayoutFormTemplate : DefnLayoutForm
{
  val borderPositionSet: Array<EnumDefnShowBorderKind>?
  val footer: DefnLayoutFormFooter?
  val header: DefnLayoutFormHeader?
  val paddingPositionSet: Array<EnumDefnShowBorderKind>?
  val paddingSize: EnumDefnThemeDividerKind?
  val paperHeight: Long?
  val paperSize: EnumDefnRenderingKind?
  val paperWidth: Long?
  val watermark: DefnLayoutFormWatermark?
}