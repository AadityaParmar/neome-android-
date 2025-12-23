// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.agent.msg

import com.neome.api.ent.agent.msg.MsgPluginApiResponse

open class MsgPluginApiResponseAccept : MsgPluginApiResponse()
{
  lateinit var responseActorPath: String
}