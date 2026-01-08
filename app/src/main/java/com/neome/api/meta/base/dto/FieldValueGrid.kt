// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldDtoGridRow
import java.util.Map
import com.neome.api.meta.base.Types.RowId

interface FieldValueGrid
{
  val keys: Array<RowId>
  val map: Map<RowId, FieldDtoGridRow>
}