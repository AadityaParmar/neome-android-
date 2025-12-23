// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdMapping
import java.util.Map

open class StudioDtoMappingFieldMapBase : StudioBase() {
    lateinit var keys: Array<MetaIdMapping>
    lateinit var map: Map<MetaIdMapping, StudioDtoMappingField>
}
