package com.neome.core.common.serializer.api.ent.entAside.sig

import com.neome.api.ent.entAside.sig.SigPluginApiOutput
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import kotlinx.serialization.Serializable


@Serializable
data class SigPluginApiOutputData(
    override val formValueRaw: FormValueRawData,
    override val outputFieldIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null
) : SigPluginApiOutput
