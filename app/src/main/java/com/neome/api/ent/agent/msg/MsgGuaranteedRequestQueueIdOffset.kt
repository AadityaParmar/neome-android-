// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.agent.msg

import com.neome.api.nucleus.base.msg.Msg

interface MsgGuaranteedRequestQueueIdOffset : Msg
{
  val offset: Long
  val queueId: String
}