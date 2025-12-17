// neome.ai API - do not change
//
/* eslint-disable @typescript-eslint/no-unused-vars */
// noinspection UnusedGlobalSymbols,ES6UnusedImports,JSUnusedGlobalSymbols,JSUnusedLocalSymbols

package com.neome.api.core.extn;

import com.neome.api.core.extn.msg.MsgExtnGstinDetailsGet;
import com.neome.api.core.extn.sig.SigExtnGstinDetails;
import com.neome.api.meta.base.Types.ServiceName;
import com.neome.api.nucleus.base.ApiPlus;
import com.neome.api.nucleus.base.CallFactory;
import com.neome.api.nucleus.base.ISigAcceptor;

@SuppressWarnings("unused")
public class RpcExtn
{
  public static final ServiceName SN = ServiceName.extn;

  public static void extnGstinDetailsGet(MsgExtnGstinDetailsGet msg,
    ISigAcceptor<SigExtnGstinDetails> sigAcceptor)
  {
    CallFactory.rpc.create(SigExtnGstinDetails.class, ApiPlus.ENT_ID_GLOBAL, SN,
        "extnGstinDetailsGet")
      .get(msg, sigAcceptor);
  }
}
