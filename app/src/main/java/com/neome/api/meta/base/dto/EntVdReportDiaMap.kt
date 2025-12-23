// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdReportDia
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdVdReportDia
import com.neome.api.meta.base.dto.StudioBase

open class EntVdReportDiaMap : StudioBase() {
    lateinit var keys: Array<MetaIdVdReportDia>
    lateinit var map: Map<MetaIdVdReportDia, EntVdReportDia>
}
