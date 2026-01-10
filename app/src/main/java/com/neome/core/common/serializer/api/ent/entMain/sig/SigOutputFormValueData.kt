package com.neome.core.common.serializer.api.ent.entMain.sig

import com.neome.api.ent.entMain.sig.SigFormValue
import com.neome.api.ent.entMain.sig.SigOutputFormValue
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FormValue
import com.neome.core.common.serializer.api.meta.base.dto.FormValueData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import kotlinx.serialization.Serializable


@Serializable
data class SigOutputFormValueData(
    override val formValue: FormValueData,
    override val outputFieldIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null
) : SigOutputFormValue
