// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.extn.msg

import com.neome.api.nucleus.base.msg.Msg

open class MsgExtnGstinDetailsGet : Msg() {
    var action: String? = null
    lateinit var gstin: String
}
