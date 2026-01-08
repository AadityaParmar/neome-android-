// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoLayoutLocmapLineStroke
import com.neome.api.meta.base.dto.DefnDtoLayoutLocmapPin
import com.neome.api.meta.base.dto.DefnLayoutGrid
import com.neome.api.meta.base.Types.EnumDefnMapRenderingMode
import com.neome.api.meta.base.Types.MetaIdField

interface DefnLayoutGridLocmap : DefnLayoutGrid
{
  val lineStroke: DefnDtoLayoutLocmapLineStroke?
  val liveLocationPin: DefnDtoLayoutLocmapPin?
  val locationFieldId: MetaIdField?
  val mapPin: DefnDtoLayoutLocmapPin?
  val renderingMode: EnumDefnMapRenderingMode?
}