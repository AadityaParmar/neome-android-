// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.agent.msg

import com.neome.api.ent.agent.msg.MsgPluginApiResponse

interface MsgPluginApiResponseAccept : MsgPluginApiResponse
{
  val responseActorPath: String
}