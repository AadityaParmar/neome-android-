// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoLayoutCardFilter
import com.neome.api.meta.base.dto.DefnDtoLayoutCardItem
import com.neome.api.meta.base.dto.DefnLayoutGrid
import com.neome.api.meta.base.Types.EnumDefnGridRenderingMode
import com.neome.api.meta.base.Types.MetaIdField

interface DefnLayoutCard : DefnLayoutGrid
{
  val filter: DefnDtoLayoutCardFilter?
  val groupByFieldId: MetaIdField?
  val hideBorders: Boolean?
  val item: DefnDtoLayoutCardItem
  val numOfColumns: Long?
  val renderingMode: EnumDefnGridRenderingMode?
  val showSearchBar: Boolean?
}