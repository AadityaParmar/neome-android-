// neome.ai API - do not change
//
/* eslint-disable @typescript-eslint/no-unused-vars */
// noinspection UnusedGlobalSymbols,ES6UnusedImports,JSUnusedGlobalSymbols,JSUnusedLocalSymbols

package com.neome.api.app.ai;

import com.neome.api.app.ai.msg.MsgAiNeoQLGet;
import com.neome.api.app.ai.msg.MsgAiNeoQLValidate;
import com.neome.api.app.ai.msg.MsgAiNeoScriptGet;
import com.neome.api.app.ai.sig.SigAiNeoQLGet;
import com.neome.api.app.ai.sig.SigAiNeoQLValidate;
import com.neome.api.app.ai.sig.SigAiNeoScriptGet;
import com.neome.api.meta.base.Types.EntId;
import com.neome.api.meta.base.Types.ServiceName;
import com.neome.api.nucleus.base.CallFactory;
import com.neome.api.nucleus.base.ISigAcceptor;

@SuppressWarnings("unused")
public class WsocAi
{
  public static final ServiceName SN = ServiceName.ai;

  public static void aiNeoQLGet(EntId entId, MsgAiNeoQLGet msg,
    ISigAcceptor<SigAiNeoQLGet> sigAcceptor)
  {
    CallFactory.wsoc.create(SigAiNeoQLGet.class, entId, SN, "aiNeoQLGet")
      .post(msg, sigAcceptor);
  }

  public static void aiNeoQLValidate(EntId entId, MsgAiNeoQLValidate msg,
    ISigAcceptor<SigAiNeoQLValidate> sigAcceptor)
  {
    CallFactory.wsoc.create(SigAiNeoQLValidate.class, entId, SN, "aiNeoQLValidate")
      .post(msg, sigAcceptor);
  }

  public static void aiNeoScriptGet(EntId entId, MsgAiNeoScriptGet msg,
    ISigAcceptor<SigAiNeoScriptGet> sigAcceptor)
  {
    CallFactory.wsoc.create(SigAiNeoScriptGet.class, entId, SN, "aiNeoScriptGet")
      .post(msg, sigAcceptor);
  }
}
