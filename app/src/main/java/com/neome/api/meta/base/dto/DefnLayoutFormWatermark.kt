// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoText
import com.neome.api.meta.base.Types.EnumDefnContentAlignment
import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.dto.FieldDtoImage

interface DefnLayoutFormWatermark
{
  val bgImage: FieldDtoImage?
  val bgImageHorizontalPosition: EnumDefnContentAlignment?
  val bgImageVar: FieldDtoImage?
  val bgImageVerticalPosition: EnumDefnContentAlignment?
  val textOpacityVar: Double?
  val textPatternVar: DefnDtoText?
  val textPositionVar: EnumDefnPlacement?
  val textSizeVar: EnumDefnTextSize?
}