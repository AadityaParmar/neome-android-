// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdReport
import com.neome.api.meta.base.dto.StudioFieldEditable

class StudioFieldPickReportRow : StudioFieldEditable() {
    var copyFieldMap: Record<MetaIdField, MetaIdField>? = null
    var editableFieldIdSet: MetaIdField[]? = null
    var gridDisplayFieldId: MetaIdField? = null
    var reportId: MetaIdReport? = null
    var reportOutputFormGridId: MetaIdGrid? = null
    var reportOutputFormGridLayoutId: MetaIdLayoutGrid? = null
    var showAsDropdown: boolean? = null
}
