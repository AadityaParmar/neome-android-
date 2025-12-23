// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user

import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.core.user.msg.MsgDeviceGet
import com.neome.api.core.user.msg.MsgFCMToken
import com.neome.api.core.otp.msg.MsgQrCodeVerify
import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.core.user.sig.SigCaller
import com.neome.api.core.user.sig.SigCallerDevice
import com.neome.api.nucleus.base.sig.SigDone

class WsocUser
{
  companion object
  {
    val SN: ServiceName = ServiceName.user

      fun callerDeviceGet(msg: MsgDeviceGet, sigAcceptor: ISigAcceptor<SigCallerDevice>)
          {
            CallFactory.wsoc.create(SigCallerDevice::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "callerDeviceGet")
              .get(msg, sigAcceptor)
          }

      fun callerGet(msg: MsgVersion, sigAcceptor: ISigAcceptor<SigCaller>)
          {
            CallFactory.wsoc.create(SigCaller::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "callerGet")
              .get(msg, sigAcceptor)
          }

      fun fCMTokenUpdate(msg: MsgFCMToken, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.wsoc.create(SigDone::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "fCMTokenUpdate")
              .put(msg, sigAcceptor)
          }

      fun qRCodeJoin(msg: MsgQrCodeVerify, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.wsoc.create(SigDone::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "qRCodeJoin")
              .post(msg, sigAcceptor)
          }
  }
}