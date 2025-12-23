// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.msg

import com.neome.api.core.base.Types.EnumMobileInviteType
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.nucleus.base.msg.Msg

open class MsgEntUserInvite : Msg() {
    var entUserIdSet: Array<EntUserId>? = null
    var inviteAllPendingUsers: Boolean? = null
    var mobileInviteType: EnumMobileInviteType? = null
}
