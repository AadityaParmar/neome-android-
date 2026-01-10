package com.neome.core.common.serializer.api.app.ai.msg

import com.neome.api.app.ai.msg.MsgAiNeoScriptGen
import com.neome.api.app.base.dto.DtoNeoScript
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.api.app.base.dto.DtoNeoScriptData
import kotlinx.serialization.Serializable


@Serializable
data class MsgAiNeoScriptGenData(
    override val dtoNeoScript: DtoNeoScriptData,
    override val userMessage: String
) : MsgAiNeoScriptGen
