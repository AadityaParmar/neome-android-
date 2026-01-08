// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.dto.StudioDtoMappingFieldMap
import com.neome.api.meta.base.dto.StudioDtoMappingGridMap

interface StudioDtoMapping
{
  val fieldMappingMap: StudioDtoMappingFieldMap?
  val fromGridId: MetaIdGrid?
  val gridMappingMap: StudioDtoMappingGridMap?
  val toGridId: MetaIdGrid?
}