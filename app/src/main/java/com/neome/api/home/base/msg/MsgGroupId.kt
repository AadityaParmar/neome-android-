// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.msg

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.meta.base.Types.GroupId

class MsgGroupId : MsgVersion() {
    val groupId: GroupId
}
