// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.agent.msg

import kotlin.properties.Delegates
import com.neome.api.nucleus.base.msg.Msg

open class MsgGuaranteedRequestQueueIdOffset : Msg()
{
  var offset: Number by Delegates.notNull<Number>()
  lateinit var queueId: String
}