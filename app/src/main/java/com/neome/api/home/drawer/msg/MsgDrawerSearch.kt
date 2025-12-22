// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.msg

import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.msg.Msg
import java.util.Set

class MsgDrawerSearch : Msg() {
    var filterEntIdSet: EntId[]? = null
    var pageSize: number? = null
    val searchId: string
    val searchQuery: string
}
