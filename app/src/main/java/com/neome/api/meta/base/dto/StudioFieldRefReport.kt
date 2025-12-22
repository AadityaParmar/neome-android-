// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdReport

class StudioFieldRefReport : StudioField() {
    var copyFieldMap: Record<MetaIdField, MetaIdField>? = null
    var editableFieldIdSet: MetaIdField[]? = null
    var forceOpenOnFormCreate: boolean? = null
    var forceOpenOnGridRowCreate: boolean? = null
    var gridId: MetaIdGrid? = null
    var keyFieldIdSet: MetaIdField[]? = null
    var layoutGridId: MetaIdLayoutGrid? = null
    var overlayLayoutGrid: StudioDtoLayoutOverlaySpreadsheet? = null
    var reportId: MetaIdReport? = null
}
