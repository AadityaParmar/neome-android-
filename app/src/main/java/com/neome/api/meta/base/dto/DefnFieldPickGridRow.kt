// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdLayoutGrid

class DefnFieldPickGridRow : DefnFieldEditable() {
    var copyFieldMap: Record<MetaIdField, MetaIdField>? = null
    var editableFieldIdSet: MetaIdField[]? = null
    var filterConditionVar: DefnStudioDtoCondition? = null
    val gridDisplayFieldId: MetaIdField
    val gridId: MetaIdGrid
    var gridLayoutId: MetaIdLayoutGrid? = null
    var showAsDropdown: boolean? = null
}
