// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.otp.msg

import com.neome.api.meta.base.AnyKey
import com.neome.api.nucleus.base.Types.AnyOtpValue
import com.neome.api.nucleus.base.msg.Msg

open class MsgOtpVerify : Msg() {
    lateinit var otp: AnyOtpValue
    lateinit var verifyKey: AnyKey
}
