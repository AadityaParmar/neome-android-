// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.msg

import com.neome.api.core.base.Types.EnumTopicType
import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.meta.base.SysId

interface MsgTopic : Msg
{
  val aboutId: SysId
  val type: EnumTopicType
}