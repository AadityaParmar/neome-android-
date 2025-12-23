// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldDtoGridRow
import java.util.Map
import com.neome.api.meta.base.Types.RowId

open class FieldValueGrid
{
  lateinit var keys: Array<RowId>
  lateinit var map: Map<RowId, FieldDtoGridRow>
}