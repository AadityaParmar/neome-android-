// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.msg

import com.neome.api.nucleus.base.msg.Msg

open class MsgUrl : Msg()
{
  lateinit var url: String
}