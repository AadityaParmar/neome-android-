package com.neome.core.common.serializer.api.app.ai.msg

import com.neome.api.app.ai.msg.MsgAiNeoScriptGet
import com.neome.api.app.base.Types.EnumKindAiAssist
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.MetaIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgAiNeoScriptGetData(
    override val kind: EnumKindAiAssist,
    override val neoScriptOrUserMessage: String,
    override val paramPath: List<@Serializable(with = MetaIdSer::class) Types.MetaId>? = null
) : MsgAiNeoScriptGet
