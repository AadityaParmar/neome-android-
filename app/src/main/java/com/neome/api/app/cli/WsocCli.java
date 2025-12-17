// neome.ai API - do not change
//
/* eslint-disable @typescript-eslint/no-unused-vars */
// noinspection UnusedGlobalSymbols,ES6UnusedImports,JSUnusedGlobalSymbols,JSUnusedLocalSymbols

package com.neome.api.app.cli;

import com.neome.api.app.cli.msg.MsgNeoScriptCtxSet;
import com.neome.api.app.cli.msg.MsgNeoScriptGet;
import com.neome.api.app.cli.msg.MsgNeoScriptPut;
import com.neome.api.app.cli.sig.SigNeoScriptGet;
import com.neome.api.app.cli.sig.SigNeoScriptPut;
import com.neome.api.meta.base.Types.EntId;
import com.neome.api.meta.base.Types.ServiceName;
import com.neome.api.nucleus.base.ApiPlus;
import com.neome.api.nucleus.base.CallFactory;
import com.neome.api.nucleus.base.ISigAcceptor;

@SuppressWarnings("unused")
public class WsocCli
{
  public static final ServiceName SN = ServiceName.cli;

  public static void neoScriptCtxSet(EntId entId, MsgNeoScriptCtxSet msg,
    ISigAcceptor<SigNeoScriptPut> sigAcceptor)
  {
    CallFactory.wsoc.create(SigNeoScriptPut.class, entId, SN, "neoScriptCtxSet")
      .put(msg, sigAcceptor);
  }

  public static void neoScriptGet(MsgNeoScriptGet msg, ISigAcceptor<SigNeoScriptGet> sigAcceptor)
  {
    CallFactory.wsoc.create(SigNeoScriptGet.class, ApiPlus.ENT_ID_GLOBAL, SN, "neoScriptGet")
      .get(msg, sigAcceptor);
  }

  public static void neoScriptPut(MsgNeoScriptPut msg, ISigAcceptor<SigNeoScriptPut> sigAcceptor)
  {
    CallFactory.wsoc.create(SigNeoScriptPut.class, ApiPlus.ENT_ID_GLOBAL, SN, "neoScriptPut")
      .put(msg, sigAcceptor);
  }
}
