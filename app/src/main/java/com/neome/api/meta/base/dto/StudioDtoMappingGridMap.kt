// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdMapping

class StudioDtoMappingGridMap : StudioBase() {
    val keys: MetaIdMapping[]
    val map: Record<MetaIdMapping, StudioDtoMappingGrid>
}
