// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.dto.StudioFieldEditable
import com.neome.api.meta.base.dto.StudioValueVarIdCondition

class StudioFieldPickGridRow : StudioFieldEditable() {
    var copyFieldMap: Record<MetaIdField, MetaIdField>? = null
    var editableFieldIdSet: MetaIdField[]? = null
    var filterConditionVarId: StudioValueVarIdCondition? = null
    var gridDisplayFieldId: MetaIdField? = null
    var gridId: MetaIdGrid? = null
    var gridLayoutId: MetaIdLayoutGrid? = null
    var showAsDropdown: boolean? = null
}
