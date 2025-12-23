// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdGrid
import java.util.Map

open class SchemaGridMap {
    lateinit var map: Map<MetaIdGrid, SchemaGrid>
}
