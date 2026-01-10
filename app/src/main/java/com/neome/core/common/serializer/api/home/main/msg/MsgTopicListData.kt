package com.neome.core.common.serializer.api.home.main.msg

import com.neome.api.core.base.dto.DtoTopic
import com.neome.api.home.main.msg.MsgTopicList
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.api.core.base.dto.DtoTopicData
import kotlinx.serialization.Serializable


@Serializable
data class MsgTopicListData(
    override val topicList: List<DtoTopicData>
) : MsgTopicList
