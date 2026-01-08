// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.agent.msg

import com.neome.api.nucleus.base.dto.EnvError
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.meta.base.Types.RequestId

interface MsgPluginApiResponse : Msg
{
  val pluginError: EnvError?
  val requestId: RequestId
  val responseFormValue: FormValueRaw?
}