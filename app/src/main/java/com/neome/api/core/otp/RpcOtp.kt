// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.otp

import com.neome.api.core.otp.msg.MsgOtpVerify
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.nucleus.base.sig.SigCallback

class RpcOtp {
    companion object {
        val SN: ServiceName = ServiceName.otp

        fun otpVerify(msg: MsgOtpVerify, sigAcceptor: ISigAcceptor<SigCallback>) {
            CallFactory.rpc.create(SigCallback::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "otpVerify")
                .post(msg, sigAcceptor)
        }
    }
}
