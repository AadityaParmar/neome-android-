// neome.ai API - do not change
//
/* eslint-disable @typescript-eslint/no-unused-vars */
// noinspection UnusedGlobalSymbols,ES6UnusedImports,JSUnusedGlobalSymbols,JSUnusedLocalSymbols

package com.neome.api.nucleus.api;

import com.neome.api.meta.base.Types.ServiceName;
import com.neome.api.nucleus.api.sig.SigApiCode;
import com.neome.api.nucleus.api.sig.SigApiLib;
import com.neome.api.nucleus.api.sig.SigClassTree;
import com.neome.api.nucleus.base.ApiPlus;
import com.neome.api.nucleus.base.CallFactory;
import com.neome.api.nucleus.base.ISigAcceptor;

@SuppressWarnings("unused")
public class RpcApi
{
  public static final ServiceName SN = ServiceName.api;

  public static void apiCodeGet(ISigAcceptor<SigApiCode> sigAcceptor)
  {
    CallFactory.rpc.create(SigApiCode.class, ApiPlus.ENT_ID_GLOBAL, SN, "apiCodeGet")
      .sendBearerToken()
      .get(null, sigAcceptor);
  }

  public static void apiListGet(ISigAcceptor<SigApiLib> sigAcceptor)
  {
    CallFactory.rpc.create(SigApiLib.class, ApiPlus.ENT_ID_GLOBAL, SN, "apiListGet")
      .sendBearerToken()
      .get(null, sigAcceptor);
  }

  public static void sysIdTreeGet(ISigAcceptor<SigClassTree> sigAcceptor)
  {
    CallFactory.rpc.create(SigClassTree.class, ApiPlus.ENT_ID_GLOBAL, SN, "sysIdTreeGet")
      .sendBearerToken()
      .get(null, sigAcceptor);
  }
}
