package com.neome.core.common.serializer.api.ent.entMain.msg

import com.neome.api.ent.entMain.msg.MsgPromptTest
import com.neome.api.nucleus.base.msg.Msg
import kotlinx.serialization.Serializable


@Serializable
data class MsgPromptTestData(
    override val handle: String,
    override val promptText: String
) : MsgPromptTest
