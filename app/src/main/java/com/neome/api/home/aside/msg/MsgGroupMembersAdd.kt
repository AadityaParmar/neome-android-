// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.aside.msg

import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.GroupId
import com.neome.api.core.base.msg.MsgVersion
import java.util.Set

interface MsgGroupMembersAdd : MsgVersion
{
  val groupId: GroupId
  val insertAdminSet: Array<EntUserId>?
  val insertMemberSet: Array<EntUserId>?
}