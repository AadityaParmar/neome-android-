// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.msg

import com.neome.api.nucleus.base.msg.Msg

open class MsgFCMToken : Msg()
{
  lateinit var fcmToken: String
}