// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.msg

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.meta.base.Types.EntId

interface MsgEntFilter : MsgVersion {
    val filterEntIdSet: List<EntId>?
}
