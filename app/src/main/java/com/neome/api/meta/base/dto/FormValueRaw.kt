// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.RowId

class FormValueRaw {
    var createdBy: EntUserId? = null
    var createdOn: string? = null
    val rowId: RowId
    var rowOrder: string? = null
    var updatedBy: EntUserId? = null
    var updatedOn: string? = null
    val valueMap: Record<MetaIdComp, any>
}
