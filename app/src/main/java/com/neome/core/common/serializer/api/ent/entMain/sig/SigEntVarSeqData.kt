package com.neome.core.common.serializer.api.ent.entMain.sig

import com.neome.api.ent.entMain.sig.SigEntVarSeq
import com.neome.api.nucleus.base.sig.Sig
import kotlinx.serialization.Serializable


@Serializable
data class SigEntVarSeqData(
    override val endSeq: Long,
    override val startSeq: Long
) : SigEntVarSeq
