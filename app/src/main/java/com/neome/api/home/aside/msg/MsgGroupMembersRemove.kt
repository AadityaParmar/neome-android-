// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.aside.msg

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.GroupId

class MsgGroupMembersRemove : MsgVersion() {
    val groupId: GroupId
    var removeAdminSet: EntUserId[]? = null
    var removeMemberSet: EntUserId[]? = null
}
