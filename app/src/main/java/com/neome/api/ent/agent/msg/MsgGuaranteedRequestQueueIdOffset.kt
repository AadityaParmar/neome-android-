// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.agent.msg

import com.neome.api.nucleus.base.msg.Msg

class MsgGuaranteedRequestQueueIdOffset : Msg() {
    val offset: number
    val queueId: string
}
