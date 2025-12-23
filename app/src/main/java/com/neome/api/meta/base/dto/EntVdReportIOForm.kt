// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdVdRegion
import com.neome.api.meta.base.dto.Point
import com.neome.api.meta.base.dto.VdBase

open class EntVdReportIOForm : VdBase() {
    var expanded: Boolean? = null
    var expandedCompositeIdSet: Array<MetaIdComposite>? = null
    lateinit var formId: MetaIdForm
    var parentRegionId: MetaIdVdRegion? = null
    var point: Point? = null
}
