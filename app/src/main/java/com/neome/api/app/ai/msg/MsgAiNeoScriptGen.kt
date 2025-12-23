// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.ai.msg

import com.neome.api.app.base.dto.DtoNeoScript
import com.neome.api.nucleus.base.msg.Msg

open class MsgAiNeoScriptGen : Msg()
{
  lateinit var dtoNeoScript: DtoNeoScript
  lateinit var userMessage: String
}