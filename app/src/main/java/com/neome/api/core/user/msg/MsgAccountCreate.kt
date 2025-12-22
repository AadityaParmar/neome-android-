// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.msg

import com.neome.api.core.base.msg.MsgHandle
import com.neome.api.meta.base.Types.EnumDeviceType
import com.neome.api.meta.base.Types.LanguageKey

class MsgAccountCreate : MsgHandle() {
    val deviceName: string
    val deviceType: EnumDeviceType
    val firstName: string
    var languageKey: LanguageKey? = null
    val lastName: string
    val newPassword: string
}
