// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.msg

import com.neome.api.meta.base.Types.EnumDeviceType
import com.neome.api.meta.base.Types.EnumIdentityProviderKind
import com.neome.api.nucleus.base.msg.Msg

class MsgSocialSignIn : Msg() {
    val deviceName: string
    val deviceType: EnumDeviceType
    val identityProviderKind: EnumIdentityProviderKind
    var nickName: string? = null
    var rememberMe: boolean? = null
    val token: string
}
