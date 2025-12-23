// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.dto.SchemaGrid

open class SchemaGridMap
{
  lateinit var map: Map<MetaIdGrid, SchemaGrid>
}