// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EnumDefnRenderingKind
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.FormValue

class DeeplinkDataPayloadEntReportShare : DeeplinkDataPayloadEnt() {
    val defnForm: DefnForm
    val formValue: FormValue
    var outputFormContentLayoutId: MetaIdLayoutForm? = null
    var outputFormTemplateLayoutId: MetaIdLayoutForm? = null
    var paperHeight: number? = null
    var paperSize: EnumDefnRenderingKind? = null
    var paperWidth: number? = null
    var reportLabel: string? = null
    val reportName: string
}
