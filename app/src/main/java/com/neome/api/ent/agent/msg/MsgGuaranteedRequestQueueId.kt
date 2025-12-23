// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.agent.msg

import kotlin.properties.Delegates
import com.neome.api.nucleus.base.msg.Msg

open class MsgGuaranteedRequestQueueId : Msg()
{
  var pageSize: Number by Delegates.notNull<Number>()
  lateinit var queueId: String
  var startOffset: Number? = null
}