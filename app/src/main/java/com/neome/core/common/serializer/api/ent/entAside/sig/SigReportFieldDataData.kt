package com.neome.core.common.serializer.api.ent.entAside.sig

import com.neome.api.ent.entAside.sig.SigReportFieldData
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.FormValue
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.core.common.serializer.api.meta.base.dto.FormValueData
import kotlinx.serialization.Serializable


@Serializable
data class SigReportFieldDataData(
    override val reportOutputForm: DefnFormData,
    override val reportOutputFormValue: FormValueData
) : SigReportFieldData
