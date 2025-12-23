// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.aside.msg

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.GroupId

open class MsgGroupMembersAdd : MsgVersion() {
    lateinit var groupId: GroupId
    var insertAdminSet: Array<EntUserId>? = null
    var insertMemberSet: Array<EntUserId>? = null
}
