// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.core.base.sig.SigVerifyKey
import com.neome.api.core.otp.msg.MsgQrCodeVerify
import com.neome.api.core.user.msg.MsgAccountCreate
import com.neome.api.core.user.msg.MsgAppVersion
import com.neome.api.core.user.msg.MsgCallerLocationPut
import com.neome.api.core.user.msg.MsgCallerSettingPut
import com.neome.api.core.user.msg.MsgContactUs
import com.neome.api.core.user.msg.MsgDeviceGet
import com.neome.api.core.user.msg.MsgFCMToken
import com.neome.api.core.user.msg.MsgForgotPassword
import com.neome.api.core.user.msg.MsgGrantBearerToken
import com.neome.api.core.user.msg.MsgOtpSignIn
import com.neome.api.core.user.msg.MsgQrCodeSignIn
import com.neome.api.core.user.msg.MsgSignIn
import com.neome.api.core.user.msg.MsgSignInUserId
import com.neome.api.core.user.msg.MsgSocialSignIn
import com.neome.api.core.user.sig.SigAppVersion
import com.neome.api.core.user.sig.SigBearerToken
import com.neome.api.core.user.sig.SigCaller
import com.neome.api.core.user.sig.SigCallerDevice
import com.neome.api.core.user.sig.SigUserSetting
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.nucleus.base.sig.SigDone
import com.neome.api.nucleus.base.sig.SigSignout
import com.neome.api.nucleus.stem.sig.SigRefreshToken

class RpcUser {
    companion object {
        val SN: ServiceName = ServiceName.user

        fun accountCreate(msg: MsgAccountCreate, sigAcceptor: ISigAcceptor<SigVerifyKey>) {
            CallFactory.rpc.create(
                SigVerifyKey::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "accountCreate"
            )
                .sendRefreshToken()
                .post(msg, sigAcceptor)
        }

        fun appVersionGet(msg: MsgAppVersion, sigAcceptor: ISigAcceptor<SigAppVersion>) {
            CallFactory.rpc.create(
                SigAppVersion::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "appVersionGet"
            )
                .get(msg, sigAcceptor)
        }

        fun callerDeviceGet(msg: MsgDeviceGet, sigAcceptor: ISigAcceptor<SigCallerDevice>) {
            CallFactory.rpc.create(
                SigCallerDevice::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "callerDeviceGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun callerGet(msg: MsgVersion, sigAcceptor: ISigAcceptor<SigCaller>) {
            CallFactory.rpc.create(SigCaller::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "callerGet")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun callerLocationPut(msg: MsgCallerLocationPut, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(
                SigDone::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "callerLocationPut"
            )
                .sendRefreshToken()
                .put(msg, sigAcceptor)
        }

        fun callerSettingGet(msg: MsgVersion, sigAcceptor: ISigAcceptor<SigUserSetting>) {
            CallFactory.rpc.create(
                SigUserSetting::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "callerSettingGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun callerSettingPut(msg: MsgCallerSettingPut, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(
                SigDone::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "callerSettingPut"
            )
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun contactUs(msg: MsgContactUs, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "contactUs")
                .post(msg, sigAcceptor)
        }

        fun fCMTokenUpdate(msg: MsgFCMToken, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "fCMTokenUpdate")
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun forgotPassword(msg: MsgForgotPassword, sigAcceptor: ISigAcceptor<SigVerifyKey>) {
            CallFactory.rpc.create(
                SigVerifyKey::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "forgotPassword"
            )
                .patch(msg, sigAcceptor)
        }

        fun grantBearerToken(msg: MsgGrantBearerToken, sigAcceptor: ISigAcceptor<SigBearerToken>) {
            CallFactory.rpc.create(
                SigBearerToken::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "grantBearerToken"
            )
                .sendRefreshToken()
                .get(msg, sigAcceptor)
        }

        fun grantRefreshToken(sigAcceptor: ISigAcceptor<SigRefreshToken>) {
            CallFactory.rpc.create(
                SigRefreshToken::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "grantRefreshToken"
            )
                .sendRefreshToken()
                .get(null, sigAcceptor)
        }

        fun otpSignIn(msg: MsgOtpSignIn, sigAcceptor: ISigAcceptor<SigVerifyKey>) {
            CallFactory.rpc.create(SigVerifyKey::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "otpSignIn")
                .sendRefreshToken()
                .post(msg, sigAcceptor)
        }

        fun ping(sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "ping")
                .sendBearerToken()
                .get(null, sigAcceptor)
        }

        fun qRCodeSignIn(msg: MsgQrCodeSignIn, sigAcceptor: ISigAcceptor<SigVerifyKey>) {
            CallFactory.rpc.create(
                SigVerifyKey::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "qRCodeSignIn"
            )
                .sendRefreshToken()
                .post(msg, sigAcceptor)
        }

        fun qRCodeVerify(msg: MsgQrCodeVerify, sigAcceptor: ISigAcceptor<SigRefreshToken>) {
            CallFactory.rpc.create(
                SigRefreshToken::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "qRCodeVerify"
            )
                .sendRefreshToken()
                .post(msg, sigAcceptor)
        }

        fun signIn(msg: MsgSignIn, sigAcceptor: ISigAcceptor<SigRefreshToken>) {
            CallFactory.rpc.create(SigRefreshToken::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "signIn")
                .sendRefreshToken()
                .post(msg, sigAcceptor)
        }

        fun signInUserId(msg: MsgSignInUserId, sigAcceptor: ISigAcceptor<SigRefreshToken>) {
            CallFactory.rpc.create(
                SigRefreshToken::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "signInUserId"
            )
                .sendRefreshToken()
                .post(msg, sigAcceptor)
        }

        fun signOut(sigAcceptor: ISigAcceptor<SigSignout>) {
            CallFactory.rpc.create(SigSignout::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "signOut")
                .sendRefreshToken()
                .post(null, sigAcceptor)
        }

        fun socialSignIn(msg: MsgSocialSignIn, sigAcceptor: ISigAcceptor<SigRefreshToken>) {
            CallFactory.rpc.create(
                SigRefreshToken::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "socialSignIn"
            )
                .sendRefreshToken()
                .post(msg, sigAcceptor)
        }
    }
}
