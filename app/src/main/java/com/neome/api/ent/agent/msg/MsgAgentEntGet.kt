// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.agent.msg

import com.neome.api.core.base.msg.MsgVersion

interface MsgAgentEntGet : MsgVersion
{
  val appVersionCode: Long?
}