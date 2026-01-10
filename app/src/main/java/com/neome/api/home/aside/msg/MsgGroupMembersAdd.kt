// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.aside.msg

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.GroupId

interface MsgGroupMembersAdd : MsgVersion {
    val groupId: GroupId
    val insertAdminSet: List<EntUserId>?
    val insertMemberSet: List<EntUserId>?
}
