package com.neome.core.common.serializer.api.ent.entMain.sig

import com.neome.api.ent.entMain.sig.SigFormMappingResultGet
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FormValue
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.api.meta.base.dto.FormValueData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import kotlinx.serialization.Serializable


@Serializable
data class SigFormMappingResultGetData(
    @Serializable(with = MetaIdFormSer::class) override val formId: Types.MetaIdForm,
    override val formValue: FormValueData,
    override val outputFieldIdSet: Set<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null
) : SigFormMappingResultGet
