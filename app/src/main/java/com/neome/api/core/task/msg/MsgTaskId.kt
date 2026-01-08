// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.task.msg

import com.neome.api.nucleus.base.msg.Msg

interface MsgTaskId : Msg
{
  val taskId: String
}