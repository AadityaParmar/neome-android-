// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdMapping

interface StudioDtoMappingFieldMapBase : StudioBase {
    val keys: List<MetaIdMapping>
    val map: Map<MetaIdMapping, StudioDtoMappingField>
}
