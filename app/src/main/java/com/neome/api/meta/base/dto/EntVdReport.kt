// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdReport
import com.neome.api.meta.base.Types.MetaIdVdRegion

class EntVdReport : StudioBase() {
    var expanded: boolean? = null
    var parentRegionId: MetaIdVdRegion? = null
    var point: Point? = null
    val reportId: MetaIdReport
}
