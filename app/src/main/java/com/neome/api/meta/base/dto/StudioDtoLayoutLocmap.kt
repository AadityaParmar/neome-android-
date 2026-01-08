// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnMapRenderingMode
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.dto.StudioDtoLayoutGrid
import com.neome.api.meta.base.dto.StudioDtoLayoutLocmapLineStroke
import com.neome.api.meta.base.dto.StudioDtoLayoutLocmapPin

interface StudioDtoLayoutLocmap : StudioDtoLayoutGrid
{
  val lineStroke: StudioDtoLayoutLocmapLineStroke?
  val liveLocationPin: StudioDtoLayoutLocmapPin?
  val locationFieldId: MetaIdField?
  val mapPin: StudioDtoLayoutLocmapPin?
  val renderingMode: EnumDefnMapRenderingMode?
}