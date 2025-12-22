// neome.ai API - do not change
//
/* eslint-disable @typescript-eslint/no-unused-vars */
// noinspection UnusedGlobalSymbols,ES6UnusedImports,JSUnusedGlobalSymbols,JSUnusedLocalSymbols

package com.neome.java.api.core.otp;

import com.neome.java.api.core.otp.msg.MsgOtpVerify;
import com.neome.java.api.meta.base.Types.ServiceName;
import com.neome.java.api.nucleus.base.ApiPlus;
import com.neome.java.api.nucleus.base.CallFactory;
import com.neome.java.api.nucleus.base.ISigAcceptor;
import com.neome.java.api.nucleus.base.sig.SigCallback;

@SuppressWarnings("unused")
public class RpcOtp
{
  public static final ServiceName SN = ServiceName.otp;

  public static void otpVerify(MsgOtpVerify msg, ISigAcceptor<SigCallback> sigAcceptor)
  {
    CallFactory.rpc.create(SigCallback.class, ApiPlus.ENT_ID_GLOBAL, SN, "otpVerify")
      .post(msg, sigAcceptor);
  }
}
