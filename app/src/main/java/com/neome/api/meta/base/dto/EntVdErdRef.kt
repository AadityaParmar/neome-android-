// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVdRegion

open class EntVdErdRef : StudioBase() {
    var diamondExpanded: Boolean? = null
    var diamondParentRegionId: MetaIdVdRegion? = null
    var diamondPoint: Point? = null
    var expanded: Boolean? = null
    lateinit var fieldId: MetaIdField
    var fromNodeHandleId: String? = null
    var fromNodeId: MetaIdSpreadsheet? = null
    var parentRegionId: MetaIdVdRegion? = null
    var point: Point? = null
    var toNodeId: MetaIdSpreadsheet? = null
}
