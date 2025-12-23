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

open class StudioDtoLayoutCardItem : StudioBase()
{
  var fifthLine: StudioDtoLayoutCardItemLine? = null
  var firstLine: StudioDtoLayoutCardItemLine? = null
  var fourthLine: StudioDtoLayoutCardItemLine? = null
  var imageBackgroundColor: StudioDtoColor? = null
  var imageCornerVarId: MetaIdVar? = null
  var imageHeight: Number? = null
  var imageHeightVarId: MetaIdVar? = null
  var imageRenderingMode: EnumDefnThemeImageRenderingMode? = null
  var imageWidth: Number? = null
  var imageWidthVarId: MetaIdVar? = null
  var mediaFieldIdSet: Array<MetaIdField>? = null
  var mediaVarIdSet: Array<MetaIdVar>? = null
  var secondLine: StudioDtoLayoutCardItemLine? = null
  var thirdLine: StudioDtoLayoutCardItemLine? = null
}