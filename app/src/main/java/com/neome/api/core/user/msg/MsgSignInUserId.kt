// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.msg

import com.neome.api.meta.base.Types.EnumDeviceType
import com.neome.api.meta.base.Types.UserId
import com.neome.api.nucleus.base.msg.Msg

class MsgSignInUserId : Msg() {
    val deviceName: string
    val deviceType: EnumDeviceType
    val password: string
    val rememberMe: boolean
    val userId: UserId
}
