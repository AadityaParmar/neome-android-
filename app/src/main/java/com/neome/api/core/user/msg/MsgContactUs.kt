// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.msg

import com.neome.api.nucleus.base.msg.Msg

class MsgContactUs : Msg() {
    var attrMap: Record<string, string>? = null
    var companyName: string? = null
    var content: string? = null
    var email: string? = null
    var fullName: string? = null
    var mobileNumber: string? = null
    var pageName: string? = null
}
