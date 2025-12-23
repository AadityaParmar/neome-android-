// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.aside.msg

import com.neome.api.meta.base.Types.GroupId
import com.neome.api.nucleus.base.msg.Msg

open class MsgGroupInviteLink : Msg()
{
  lateinit var groupId: GroupId
  var reset: Boolean? = null
}