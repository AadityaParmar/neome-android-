package com.neome.core.common.serializer.api.ent.entMain.msg

import com.neome.api.ent.entMain.msg.MsgEntVarSeqIncr
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgEntVarSeqIncrData(
    @Serializable(with = MetaIdVarSer::class) override val seqVarId: Types.MetaIdVar,
    override val step: Long? = null
) : MsgEntVarSeqIncr
