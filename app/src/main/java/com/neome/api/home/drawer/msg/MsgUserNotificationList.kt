// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.msg

import com.neome.api.core.base.msg.MsgVersion

class MsgUserNotificationList : MsgVersion() {
    var limit: number? = null
    var offset: number? = null
}
