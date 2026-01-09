package com.neome.core.common.serializer.api.home.main.msg

import com.neome.api.core.base.dto.DtoTopic
import com.neome.api.home.main.msg.MsgTopicList
import com.neome.api.nucleus.base.msg.Msg
import kotlinx.serialization.Serializable


@Serializable
data class MsgTopicListData(
    override val topicList: Array<DtoTopic>
) : MsgTopicList
