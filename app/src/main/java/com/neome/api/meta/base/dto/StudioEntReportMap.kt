// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdReport
import java.util.Map

open class StudioEntReportMap : StudioBase() {
    lateinit var keys: Array<MetaIdReport>
    lateinit var map: Map<MetaIdReport, StudioEntReport>
}
