// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.aside.msg

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.GroupId

open class MsgGroupMembersRemove : MsgVersion() {
    lateinit var groupId: GroupId
    var removeAdminSet: Array<EntUserId>? = null
    var removeMemberSet: Array<EntUserId>? = null
}
