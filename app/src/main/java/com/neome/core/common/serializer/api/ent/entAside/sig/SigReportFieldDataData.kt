package com.neome.core.common.serializer.api.ent.entAside.sig

import com.neome.api.ent.entAside.sig.SigReportFieldData
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.FormValue
import com.neome.api.nucleus.base.sig.Sig
import kotlinx.serialization.Serializable


@Serializable
data class SigReportFieldDataData(
    override val reportOutputForm: DefnForm,
    override val reportOutputFormValue: FormValue
) : SigReportFieldData
