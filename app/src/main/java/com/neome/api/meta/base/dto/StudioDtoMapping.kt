// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.dto.StudioDtoMappingFieldMap
import com.neome.api.meta.base.dto.StudioDtoMappingGridMap

open class StudioDtoMapping
{
  var fieldMappingMap: StudioDtoMappingFieldMap? = null
  var fromGridId: MetaIdGrid? = null
  var gridMappingMap: StudioDtoMappingGridMap? = null
  var toGridId: MetaIdGrid? = null
}