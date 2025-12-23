// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdReport
import java.util.Map

open class StudioFieldRefReport : StudioField() {
    var copyFieldMap: Map<MetaIdField, MetaIdField>? = null
    var editableFieldIdSet: Array<MetaIdField>? = null
    var forceOpenOnFormCreate: Boolean? = null
    var forceOpenOnGridRowCreate: Boolean? = null
    var gridId: MetaIdGrid? = null
    var keyFieldIdSet: Array<MetaIdField>? = null
    var layoutGridId: MetaIdLayoutGrid? = null
    var overlayLayoutGrid: StudioDtoLayoutOverlaySpreadsheet? = null
    var reportId: MetaIdReport? = null
}
