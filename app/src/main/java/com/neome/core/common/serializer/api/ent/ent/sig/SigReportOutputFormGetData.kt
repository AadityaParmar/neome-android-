package com.neome.core.common.serializer.api.ent.ent.sig

import com.neome.api.ent.ent.sig.SigReportOutputFormGet
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FormValue
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.api.meta.base.dto.FormValueData
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormSer
import kotlinx.serialization.Serializable


@Serializable
data class SigReportOutputFormGetData(
    @Serializable(with = MetaIdFormSer::class) override val formId: Types.MetaIdForm,
    override val formValue: FormValueData,
    @Serializable(with = MetaIdLayoutFormSer::class) override val outputFormContentLayoutId: Types.MetaIdLayoutForm? = null,
    @Serializable(with = MetaIdLayoutFormSer::class) override val outputFormTemplateLayoutId: Types.MetaIdLayoutForm? = null,
    override val reportLabel: String? = null,
    override val reportName: String
) : SigReportOutputFormGet
