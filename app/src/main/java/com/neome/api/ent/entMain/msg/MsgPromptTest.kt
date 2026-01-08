// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.nucleus.base.msg.Msg

interface MsgPromptTest : Msg
{
  val handle: String
  val promptText: String
}