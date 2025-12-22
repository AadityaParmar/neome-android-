// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.msg

import com.neome.api.meta.base.Types.TabId
import com.neome.api.nucleus.base.Types.AppVersion
import com.neome.api.nucleus.base.msg.Msg

class MsgGrantBearerToken : Msg() {
    val appVersion: AppVersion
    var sendCaller: boolean? = null
    val tabId: TabId
}
