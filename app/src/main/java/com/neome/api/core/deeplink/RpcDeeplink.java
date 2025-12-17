// neome.ai API - do not change
//
/* eslint-disable @typescript-eslint/no-unused-vars */
// noinspection UnusedGlobalSymbols,ES6UnusedImports,JSUnusedGlobalSymbols,JSUnusedLocalSymbols

package com.neome.api.core.deeplink;

import com.neome.api.core.deeplink.msg.MsgDeeplinkCode;
import com.neome.api.core.deeplink.msg.MsgDeeplinkCodeAction;
import com.neome.api.core.deeplink.msg.MsgDeeplinkHtml;
import com.neome.api.core.deeplink.sig.SigDeeplinkData;
import com.neome.api.core.deeplink.sig.SigDeeplinkHtml;
import com.neome.api.core.deeplink.sig.SigDeeplinkPreview;
import com.neome.api.meta.base.Types.ServiceName;
import com.neome.api.nucleus.base.ApiPlus;
import com.neome.api.nucleus.base.CallFactory;
import com.neome.api.nucleus.base.ISigAcceptor;
import com.neome.api.nucleus.base.sig.SigCallback;

@SuppressWarnings("unused")
public class RpcDeeplink
{
  public static final ServiceName SN = ServiceName.deeplink;

  public static void deeplinkAction(MsgDeeplinkCodeAction msg,
    ISigAcceptor<SigCallback> sigAcceptor)
  {
    CallFactory.rpc.create(SigCallback.class, ApiPlus.ENT_ID_GLOBAL, SN, "deeplinkAction")
      .sendRefreshToken()
      .post(msg, sigAcceptor);
  }

  public static void deeplinkDataGet(MsgDeeplinkCode msg, ISigAcceptor<SigDeeplinkData> sigAcceptor)
  {
    CallFactory.rpc.create(SigDeeplinkData.class, ApiPlus.ENT_ID_GLOBAL, SN, "deeplinkDataGet")
      .sendRefreshToken()
      .get(msg, sigAcceptor);
  }

  public static void deeplinkHtmlGet(MsgDeeplinkHtml msg, ISigAcceptor<SigDeeplinkHtml> sigAcceptor)
  {
    CallFactory.rpc.create(SigDeeplinkHtml.class, ApiPlus.ENT_ID_GLOBAL, SN, "deeplinkHtmlGet")
      .get(msg, sigAcceptor);
  }

  public static void deeplinkPreviewGet(MsgDeeplinkCode msg,
    ISigAcceptor<SigDeeplinkPreview> sigAcceptor)
  {
    CallFactory.rpc.create(SigDeeplinkPreview.class, ApiPlus.ENT_ID_GLOBAL, SN,
        "deeplinkPreviewGet")
      .get(msg, sigAcceptor);
  }
}
