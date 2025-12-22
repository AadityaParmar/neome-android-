// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.extn.msg

import com.neome.api.nucleus.base.msg.Msg

class MsgExtnGstinDetailsGet : Msg() {
    var action: string? = null
    val gstin: string
}
