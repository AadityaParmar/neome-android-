// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdReport

class DefnFieldPickReportRow : DefnFieldEditable() {
    var copyFieldMap: Record<MetaIdField, MetaIdField>? = null
    var editableFieldIdSet: MetaIdField[]? = null
    var gridDisplayFieldId: MetaIdField? = null
    val reportId: MetaIdReport
    var reportOutputFormGridId: MetaIdGrid? = null
    var reportOutputFormGridLayout: DefnLayoutGrid? = null
    var showAsDropdown: boolean? = null
}
