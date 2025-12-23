// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoLayoutOverlaySpreadsheet
import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.dto.DefnLayoutGrid
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdReport

open class DefnFieldRefReport : DefnField() {
    var copyFieldMap: Map<MetaIdField, MetaIdField>? = null
    var editableFieldIdSet: Array<MetaIdField>? = null
    var forceOpenOnFormCreate: Boolean? = null
    var forceOpenOnGridRowCreate: Boolean? = null
    var gridId: MetaIdGrid? = null
    var keyFieldIdSet: Array<MetaIdField>? = null
    var layoutGrid: DefnLayoutGrid? = null
    var overlayLayoutGrid: DefnDtoLayoutOverlaySpreadsheet? = null
    lateinit var reportId: MetaIdReport
}
