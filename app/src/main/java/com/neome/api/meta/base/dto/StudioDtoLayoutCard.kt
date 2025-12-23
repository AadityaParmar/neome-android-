// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnGridRenderingMode
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.dto.StudioDtoLayoutCardFilter
import com.neome.api.meta.base.dto.StudioDtoLayoutCardItem
import com.neome.api.meta.base.dto.StudioDtoLayoutGrid

open class StudioDtoLayoutCard : StudioDtoLayoutGrid()
{
  var filter: StudioDtoLayoutCardFilter? = null
  var groupByFieldId: MetaIdField? = null
  var hideBorders: Boolean? = null
  var item: StudioDtoLayoutCardItem? = null
  var numOfColumns: Number? = null
  var renderingMode: EnumDefnGridRenderingMode? = null
  var showSearchBar: Boolean? = null
}