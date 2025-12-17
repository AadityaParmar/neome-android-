// neome.ai API - do not change
//
/* eslint-disable @typescript-eslint/no-unused-vars */
// noinspection UnusedGlobalSymbols,ES6UnusedImports,JSUnusedGlobalSymbols,JSUnusedLocalSymbols

package com.neome.api.core.user;

import com.neome.api.core.base.msg.MsgVersion;
import com.neome.api.core.base.sig.SigVerifyKey;
import com.neome.api.core.otp.msg.MsgQrCodeVerify;
import com.neome.api.core.user.msg.MsgAccountCreate;
import com.neome.api.core.user.msg.MsgAppVersion;
import com.neome.api.core.user.msg.MsgCallerLocationPut;
import com.neome.api.core.user.msg.MsgCallerSettingPut;
import com.neome.api.core.user.msg.MsgContactUs;
import com.neome.api.core.user.msg.MsgDeviceGet;
import com.neome.api.core.user.msg.MsgFCMToken;
import com.neome.api.core.user.msg.MsgForgotPassword;
import com.neome.api.core.user.msg.MsgGrantBearerToken;
import com.neome.api.core.user.msg.MsgOtpSignIn;
import com.neome.api.core.user.msg.MsgQrCodeSignIn;
import com.neome.api.core.user.msg.MsgSignIn;
import com.neome.api.core.user.msg.MsgSignInUserId;
import com.neome.api.core.user.msg.MsgSocialSignIn;
import com.neome.api.core.user.sig.SigAppVersion;
import com.neome.api.core.user.sig.SigBearerToken;
import com.neome.api.core.user.sig.SigCaller;
import com.neome.api.core.user.sig.SigCallerDevice;
import com.neome.api.core.user.sig.SigUserSetting;
import com.neome.api.meta.base.Types.ServiceName;
import com.neome.api.nucleus.base.ApiPlus;
import com.neome.api.nucleus.base.CallFactory;
import com.neome.api.nucleus.base.ISigAcceptor;
import com.neome.api.nucleus.base.sig.SigDone;
import com.neome.api.nucleus.base.sig.SigSignout;
import com.neome.api.nucleus.stem.sig.SigRefreshToken;

@SuppressWarnings("unused")
public class RpcUser
{
  public static final ServiceName SN = ServiceName.user;

  public static void accountCreate(MsgAccountCreate msg, ISigAcceptor<SigVerifyKey> sigAcceptor)
  {
    CallFactory.rpc.create(SigVerifyKey.class, ApiPlus.ENT_ID_GLOBAL, SN, "accountCreate")
      .sendRefreshToken()
      .post(msg, sigAcceptor);
  }

  public static void appVersionGet(MsgAppVersion msg, ISigAcceptor<SigAppVersion> sigAcceptor)
  {
    CallFactory.rpc.create(SigAppVersion.class, ApiPlus.ENT_ID_GLOBAL, SN, "appVersionGet")
      .get(msg, sigAcceptor);
  }

  public static void callerDeviceGet(MsgDeviceGet msg, ISigAcceptor<SigCallerDevice> sigAcceptor)
  {
    CallFactory.rpc.create(SigCallerDevice.class, ApiPlus.ENT_ID_GLOBAL, SN, "callerDeviceGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void callerGet(MsgVersion msg, ISigAcceptor<SigCaller> sigAcceptor)
  {
    CallFactory.rpc.create(SigCaller.class, ApiPlus.ENT_ID_GLOBAL, SN, "callerGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void callerLocationPut(MsgCallerLocationPut msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "callerLocationPut")
      .sendRefreshToken()
      .put(msg, sigAcceptor);
  }

  public static void callerSettingGet(MsgVersion msg, ISigAcceptor<SigUserSetting> sigAcceptor)
  {
    CallFactory.rpc.create(SigUserSetting.class, ApiPlus.ENT_ID_GLOBAL, SN, "callerSettingGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void callerSettingPut(MsgCallerSettingPut msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "callerSettingPut")
      .sendBearerToken()
      .put(msg, sigAcceptor);
  }

  public static void contactUs(MsgContactUs msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "contactUs")
      .post(msg, sigAcceptor);
  }

  public static void fCMTokenUpdate(MsgFCMToken msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "fCMTokenUpdate")
      .sendBearerToken()
      .put(msg, sigAcceptor);
  }

  public static void forgotPassword(MsgForgotPassword msg, ISigAcceptor<SigVerifyKey> sigAcceptor)
  {
    CallFactory.rpc.create(SigVerifyKey.class, ApiPlus.ENT_ID_GLOBAL, SN, "forgotPassword")
      .patch(msg, sigAcceptor);
  }

  public static void grantBearerToken(MsgGrantBearerToken msg,
    ISigAcceptor<SigBearerToken> sigAcceptor)
  {
    CallFactory.rpc.create(SigBearerToken.class, ApiPlus.ENT_ID_GLOBAL, SN, "grantBearerToken")
      .sendRefreshToken()
      .get(msg, sigAcceptor);
  }

  public static void grantRefreshToken(ISigAcceptor<SigRefreshToken> sigAcceptor)
  {
    CallFactory.rpc.create(SigRefreshToken.class, ApiPlus.ENT_ID_GLOBAL, SN, "grantRefreshToken")
      .sendRefreshToken()
      .get(null, sigAcceptor);
  }

  public static void otpSignIn(MsgOtpSignIn msg, ISigAcceptor<SigVerifyKey> sigAcceptor)
  {
    CallFactory.rpc.create(SigVerifyKey.class, ApiPlus.ENT_ID_GLOBAL, SN, "otpSignIn")
      .sendRefreshToken()
      .post(msg, sigAcceptor);
  }

  public static void ping(ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "ping")
      .sendBearerToken()
      .get(null, sigAcceptor);
  }

  public static void qRCodeSignIn(MsgQrCodeSignIn msg, ISigAcceptor<SigVerifyKey> sigAcceptor)
  {
    CallFactory.rpc.create(SigVerifyKey.class, ApiPlus.ENT_ID_GLOBAL, SN, "qRCodeSignIn")
      .sendRefreshToken()
      .post(msg, sigAcceptor);
  }

  public static void qRCodeVerify(MsgQrCodeVerify msg, ISigAcceptor<SigRefreshToken> sigAcceptor)
  {
    CallFactory.rpc.create(SigRefreshToken.class, ApiPlus.ENT_ID_GLOBAL, SN, "qRCodeVerify")
      .sendRefreshToken()
      .post(msg, sigAcceptor);
  }

  public static void signIn(MsgSignIn msg, ISigAcceptor<SigRefreshToken> sigAcceptor)
  {
    CallFactory.rpc.create(SigRefreshToken.class, ApiPlus.ENT_ID_GLOBAL, SN, "signIn")
      .sendRefreshToken()
      .post(msg, sigAcceptor);
  }

  public static void signInUserId(MsgSignInUserId msg, ISigAcceptor<SigRefreshToken> sigAcceptor)
  {
    CallFactory.rpc.create(SigRefreshToken.class, ApiPlus.ENT_ID_GLOBAL, SN, "signInUserId")
      .sendRefreshToken()
      .post(msg, sigAcceptor);
  }

  public static void signOut(ISigAcceptor<SigSignout> sigAcceptor)
  {
    CallFactory.rpc.create(SigSignout.class, ApiPlus.ENT_ID_GLOBAL, SN, "signOut")
      .sendRefreshToken()
      .post(null, sigAcceptor);
  }

  public static void socialSignIn(MsgSocialSignIn msg, ISigAcceptor<SigRefreshToken> sigAcceptor)
  {
    CallFactory.rpc.create(SigRefreshToken.class, ApiPlus.ENT_ID_GLOBAL, SN, "socialSignIn")
      .sendRefreshToken()
      .post(msg, sigAcceptor);
  }
}
