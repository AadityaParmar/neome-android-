// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdVdRegion

class EntVdReportIOForm : VdBase() {
    var expanded: boolean? = null
    var expandedCompositeIdSet: MetaIdComposite[]? = null
    val formId: MetaIdForm
    var parentRegionId: MetaIdVdRegion? = null
    var point: Point? = null
}
