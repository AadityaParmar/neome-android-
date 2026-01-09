package com.neome.core.common.serializer.api.home.main.msg

import com.neome.api.core.base.Types.EnumTopicType
import com.neome.api.home.main.msg.MsgTopic
import com.neome.api.meta.base.SysId
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.SysIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgTopicData(
    @Serializable(with = SysIdSer::class) override val aboutId: SysId,
    override val type: EnumTopicType
) : MsgTopic
