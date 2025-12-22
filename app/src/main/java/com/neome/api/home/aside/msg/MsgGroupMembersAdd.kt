// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.aside.msg

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.GroupId

class MsgGroupMembersAdd : MsgVersion() {
    val groupId: GroupId
    var insertAdminSet: EntUserId[]? = null
    var insertMemberSet: EntUserId[]? = null
}
