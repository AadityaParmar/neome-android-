// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.msg

import com.neome.api.core.base.Types.EnumMobileInviteType
import com.neome.api.meta.base.Types.AdminId
import com.neome.api.nucleus.base.msg.Msg

open class MsgAdminInvite : Msg() {
    var adminIdSet: Array<AdminId>? = null
    var inviteAllPendingAdmins: Boolean? = null
    var mobileInviteType: EnumMobileInviteType? = null
}
