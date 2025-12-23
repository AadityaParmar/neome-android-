// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.msg

import com.neome.api.core.base.msg.MsgVersion

open class MsgUserNotificationList : MsgVersion()
{
  var limit: Number? = null
  var offset: Number? = null
}