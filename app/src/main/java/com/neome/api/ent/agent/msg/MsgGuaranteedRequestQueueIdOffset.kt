// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.agent.msg

import com.neome.api.nucleus.base.msg.Msg
import kotlin.properties.Delegates

open class MsgGuaranteedRequestQueueIdOffset : Msg() {
    var offset: Number by Delegates.notNull<Number>()
    lateinit var queueId: String
}
