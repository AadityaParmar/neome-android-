// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdMapping
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoMappingGrid

open class StudioDtoMappingGridMap : StudioBase()
{
  lateinit var keys: Array<MetaIdMapping>
  lateinit var map: Map<MetaIdMapping, StudioDtoMappingGrid>
}