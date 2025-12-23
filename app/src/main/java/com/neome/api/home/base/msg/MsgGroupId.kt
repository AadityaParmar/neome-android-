// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.msg

import com.neome.api.meta.base.Types.GroupId
import com.neome.api.core.base.msg.MsgVersion

open class MsgGroupId : MsgVersion()
{
  lateinit var groupId: GroupId
}