// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdReport
import com.neome.api.meta.base.Types.MetaIdVdReportDia

class EntVdReportDia : EntVdDia() {
    var ioFormMap: Record<MetaIdForm, EntVdReportIOForm>? = null
    var label: string? = null
    val metaId: MetaIdVdReportDia
    val name: Symbol
    var reportMap: Record<MetaIdReport, EntVdReport>? = null
}
