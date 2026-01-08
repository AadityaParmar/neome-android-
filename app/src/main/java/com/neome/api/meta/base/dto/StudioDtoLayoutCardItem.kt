// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemeImageRenderingMode
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.api.meta.base.dto.StudioDtoLayoutCardItemLine

interface StudioDtoLayoutCardItem : StudioBase
{
  val fifthLine: StudioDtoLayoutCardItemLine?
  val firstLine: StudioDtoLayoutCardItemLine?
  val fourthLine: StudioDtoLayoutCardItemLine?
  val imageBackgroundColor: StudioDtoColor?
  val imageCornerVarId: MetaIdVar?
  val imageHeight: Long?
  val imageHeightVarId: MetaIdVar?
  val imageRenderingMode: EnumDefnThemeImageRenderingMode?
  val imageWidth: Long?
  val imageWidthVarId: MetaIdVar?
  val mediaFieldIdSet: Array<MetaIdField>?
  val mediaVarIdSet: Array<MetaIdVar>?
  val secondLine: StudioDtoLayoutCardItemLine?
  val thirdLine: StudioDtoLayoutCardItemLine?
}