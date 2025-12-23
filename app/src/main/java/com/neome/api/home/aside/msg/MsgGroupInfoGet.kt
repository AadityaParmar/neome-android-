// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.aside.msg

import com.neome.api.meta.base.Types.GroupId
import com.neome.api.core.base.msg.MsgVersion

open class MsgGroupInfoGet : MsgVersion()
{
  lateinit var groupId: GroupId
}