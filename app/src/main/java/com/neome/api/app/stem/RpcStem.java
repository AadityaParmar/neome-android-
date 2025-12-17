// neome.ai API - do not change
//
/* eslint-disable @typescript-eslint/no-unused-vars */
// noinspection UnusedGlobalSymbols,ES6UnusedImports,JSUnusedGlobalSymbols,JSUnusedLocalSymbols

package com.neome.api.app.stem;

import com.neome.api.meta.base.Types.ServiceName;
import com.neome.api.nucleus.base.ApiPlus;
import com.neome.api.nucleus.base.CallFactory;
import com.neome.api.nucleus.base.ISigAcceptor;
import com.neome.api.nucleus.base.sig.SigDone;

@SuppressWarnings("unused")
public class RpcStem
{
  public static final ServiceName SN = ServiceName.stem;

  public static void migrateArtifacts(ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "migrateArtifacts")
      .sendBearerToken()
      .get(null, sigAcceptor);
  }
}
