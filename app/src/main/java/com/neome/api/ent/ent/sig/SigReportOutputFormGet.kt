// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.ent.sig

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.dto.FormValue
import com.neome.api.nucleus.base.sig.Sig

class SigReportOutputFormGet : Sig() {
    val formId: MetaIdForm
    val formValue: FormValue
    var outputFormContentLayoutId: MetaIdLayoutForm? = null
    var outputFormTemplateLayoutId: MetaIdLayoutForm? = null
    var reportLabel: string? = null
    val reportName: string
}
