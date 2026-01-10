// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdReport

interface StudioEntReportMap : StudioBase {
    val keys: List<MetaIdReport>
    val map: Map<MetaIdReport, StudioEntReport>
}
