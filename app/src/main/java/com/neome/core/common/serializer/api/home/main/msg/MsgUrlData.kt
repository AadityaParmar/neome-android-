package com.neome.core.common.serializer.api.home.main.msg

import com.neome.api.home.main.msg.MsgUrl
import com.neome.api.nucleus.base.msg.Msg
import kotlinx.serialization.Serializable


@Serializable
data class MsgUrlData(
    override val url: String
) : MsgUrl
