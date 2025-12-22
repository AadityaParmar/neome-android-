// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdVdReportDia

class EntVdReportDiaMap : StudioBase() {
    val keys: MetaIdVdReportDia[]
    val map: Record<MetaIdVdReportDia, EntVdReportDia>
}
