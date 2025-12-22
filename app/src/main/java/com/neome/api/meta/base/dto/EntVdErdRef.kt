// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVdRegion

class EntVdErdRef : StudioBase() {
    var diamondExpanded: boolean? = null
    var diamondParentRegionId: MetaIdVdRegion? = null
    var diamondPoint: Point? = null
    var expanded: boolean? = null
    val fieldId: MetaIdField
    var fromNodeHandleId: string? = null
    var fromNodeId: MetaIdSpreadsheet? = null
    var parentRegionId: MetaIdVdRegion? = null
    var point: Point? = null
    var toNodeId: MetaIdSpreadsheet? = null
}
