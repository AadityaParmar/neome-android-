// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import java.util.Map

open class StudioFieldPickGridRow : StudioFieldEditable() {
    var copyFieldMap: Map<MetaIdField, MetaIdField>? = null
    var editableFieldIdSet: Array<MetaIdField>? = null
    var filterConditionVarId: StudioValueVarIdCondition? = null
    var gridDisplayFieldId: MetaIdField? = null
    var gridId: MetaIdGrid? = null
    var gridLayoutId: MetaIdLayoutGrid? = null
    var showAsDropdown: Boolean? = null
}
