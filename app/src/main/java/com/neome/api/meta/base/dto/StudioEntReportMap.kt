// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdReport

class StudioEntReportMap : StudioBase() {
    val keys: MetaIdReport[]
    val map: Record<MetaIdReport, StudioEntReport>
}
