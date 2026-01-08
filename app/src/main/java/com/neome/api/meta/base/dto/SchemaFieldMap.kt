// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.dto.SchemaColumnMap

interface SchemaFieldMap
{
  val map: Map<MetaIdField, SchemaColumnMap>
}