// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnGridRenderingMode
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.dto.StudioDtoLayoutCardFilter
import com.neome.api.meta.base.dto.StudioDtoLayoutCardItem
import com.neome.api.meta.base.dto.StudioDtoLayoutGrid

interface StudioDtoLayoutCard : StudioDtoLayoutGrid
{
  val filter: StudioDtoLayoutCardFilter?
  val groupByFieldId: MetaIdField?
  val hideBorders: Boolean?
  val item: StudioDtoLayoutCardItem?
  val numOfColumns: Long?
  val renderingMode: EnumDefnGridRenderingMode?
  val showSearchBar: Boolean?
}