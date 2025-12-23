// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.msg

import com.neome.api.core.base.msg.MsgVersion

open class MsgEntUserListGet : MsgVersion() {
    var lastOnlineRequired: Boolean? = null
}
