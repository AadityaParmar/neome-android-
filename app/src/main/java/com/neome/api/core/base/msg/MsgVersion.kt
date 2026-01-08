// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base.msg

import com.neome.api.nucleus.base.msg.Msg

interface MsgVersion : Msg
{
  val version: String?
}