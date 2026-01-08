// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.msg

import com.neome.api.home.main.msg.MsgMessageList

interface MsgMessageListOffset : MsgMessageList
{
  val offset: Long?
}