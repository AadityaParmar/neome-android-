// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.msg

import com.neome.api.core.base.dto.DtoChatMessageOffset
import com.neome.api.home.base.dto.DtoMessagePayload
import com.neome.api.home.main.msg.MsgOffset

interface MsgMessageEdit : MsgOffset
{
  val chatMessageOffset: DtoChatMessageOffset?
  val dtoMessagePayload: DtoMessagePayload?
}