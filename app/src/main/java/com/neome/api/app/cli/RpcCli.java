// neome.ai API - do not change
//
/* eslint-disable @typescript-eslint/no-unused-vars */
// noinspection UnusedGlobalSymbols,ES6UnusedImports,JSUnusedGlobalSymbols,JSUnusedLocalSymbols

package com.neome.api.app.cli;

import com.neome.api.app.cli.msg.MsgNeoScriptGet;
import com.neome.api.app.cli.sig.SigNeoScriptGet;
import com.neome.api.meta.base.Types.ServiceName;
import com.neome.api.nucleus.base.ApiPlus;
import com.neome.api.nucleus.base.CallFactory;
import com.neome.api.nucleus.base.ISigAcceptor;

@SuppressWarnings("unused")
public class RpcCli
{
  public static final ServiceName SN = ServiceName.cli;

  public static void neoScriptGet(MsgNeoScriptGet msg, ISigAcceptor<SigNeoScriptGet> sigAcceptor)
  {
    CallFactory.rpc.create(SigNeoScriptGet.class, ApiPlus.ENT_ID_GLOBAL, SN, "neoScriptGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }
}
