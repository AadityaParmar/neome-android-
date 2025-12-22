// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.msg

import com.neome.api.core.base.msg.MsgHandle

class MsgForgotPassword : MsgHandle() {
    val newPassword: string
}
