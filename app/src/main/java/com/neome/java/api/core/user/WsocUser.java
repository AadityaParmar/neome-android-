// neome.ai API - do not change
//
/* eslint-disable @typescript-eslint/no-unused-vars */
// noinspection UnusedGlobalSymbols,ES6UnusedImports,JSUnusedGlobalSymbols,JSUnusedLocalSymbols

package com.neome.java.api.core.user;

import com.neome.java.api.core.base.msg.MsgVersion;
import com.neome.java.api.core.otp.msg.MsgQrCodeVerify;
import com.neome.java.api.core.user.msg.MsgDeviceGet;
import com.neome.java.api.core.user.msg.MsgFCMToken;
import com.neome.java.api.core.user.sig.SigCaller;
import com.neome.java.api.core.user.sig.SigCallerDevice;
import com.neome.java.api.meta.base.Types.ServiceName;
import com.neome.java.api.nucleus.base.ApiPlus;
import com.neome.java.api.nucleus.base.CallFactory;
import com.neome.java.api.nucleus.base.ISigAcceptor;
import com.neome.java.api.nucleus.base.sig.SigDone;

@SuppressWarnings("unused")
public class WsocUser
{
  public static final ServiceName SN = ServiceName.user;

  public static void callerDeviceGet(MsgDeviceGet msg, ISigAcceptor<SigCallerDevice> sigAcceptor)
  {
    CallFactory.wsoc.create(SigCallerDevice.class, ApiPlus.ENT_ID_GLOBAL, SN, "callerDeviceGet")
      .get(msg, sigAcceptor);
  }

  public static void callerGet(MsgVersion msg, ISigAcceptor<SigCaller> sigAcceptor)
  {
    CallFactory.wsoc.create(SigCaller.class, ApiPlus.ENT_ID_GLOBAL, SN, "callerGet")
      .get(msg, sigAcceptor);
  }

  public static void fCMTokenUpdate(MsgFCMToken msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "fCMTokenUpdate")
      .put(msg, sigAcceptor);
  }

  public static void qRCodeJoin(MsgQrCodeVerify msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "qRCodeJoin")
      .post(msg, sigAcceptor);
  }
}
