// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base.msg

import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.nucleus.base.msg.Msg

class MsgEntUserIdSet : Msg() {
    var entUserId: EntUserId? = null
    var entUserIdSet: EntUserId[]? = null
}
