// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.RowId
import java.util.Map

open class FieldValueGrid {
    lateinit var keys: Array<RowId>
    lateinit var map: Map<RowId, FieldDtoGridRow>
}
