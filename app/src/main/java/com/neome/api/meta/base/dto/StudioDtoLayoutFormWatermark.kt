// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnContentAlignment
import com.neome.api.meta.base.dto.FieldDtoImage
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioValueVarIdText

interface StudioDtoLayoutFormWatermark : StudioBase
{
  val bgImage: FieldDtoImage?
  val bgImageHorizontalPosition: EnumDefnContentAlignment?
  val bgImageVarId: MetaIdVar?
  val bgImageVerticalPosition: EnumDefnContentAlignment?
  val textOpacityVarId: MetaIdVar?
  val textPatternVarId: StudioValueVarIdText?
  val textPositionVarId: MetaIdVar?
  val textSizeVarId: MetaIdVar?
}