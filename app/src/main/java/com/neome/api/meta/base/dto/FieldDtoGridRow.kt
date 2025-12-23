// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.RowId
import java.util.Map

open class FieldDtoGridRow {
    var createdBy: EntUserId? = null
    var createdOn: String? = null
    lateinit var rowId: RowId
    var rowOrder: String? = null
    var updatedBy: EntUserId? = null
    var updatedOn: String? = null
    var valueMap: Map<MetaIdField, Any>? = null
}
