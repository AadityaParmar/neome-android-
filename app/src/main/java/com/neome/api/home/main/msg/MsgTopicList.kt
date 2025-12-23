// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.msg

import com.neome.api.core.base.dto.DtoTopic
import com.neome.api.nucleus.base.msg.Msg

open class MsgTopicList : Msg() {
    lateinit var topicList: Array<DtoTopic>
}
