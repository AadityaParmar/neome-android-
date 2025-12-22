// neome.ai API - do not change
//
/* eslint-disable @typescript-eslint/no-unused-vars */
// noinspection UnusedGlobalSymbols,ES6UnusedImports,JSUnusedGlobalSymbols,JSUnusedLocalSymbols

package com.neome.java.api.core.cluster;

import com.neome.java.api.core.cluster.msg.MsgClusterItemDataGet;
import com.neome.java.api.core.cluster.sig.SigClusterItemData;
import com.neome.java.api.core.cluster.sig.SigClusterItemList;
import com.neome.java.api.meta.base.Types.ServiceName;
import com.neome.java.api.nucleus.base.ApiPlus;
import com.neome.java.api.nucleus.base.CallFactory;
import com.neome.java.api.nucleus.base.ISigAcceptor;
import com.neome.java.api.nucleus.base.sig.SigDone;

@SuppressWarnings("unused")
public class RpcCluster
{
  public static final ServiceName SN = ServiceName.cluster;

  public static void clusterItemDataGet(MsgClusterItemDataGet msg,
    ISigAcceptor<SigClusterItemData> sigAcceptor)
  {
    CallFactory.rpc.create(SigClusterItemData.class, ApiPlus.ENT_ID_GLOBAL, SN,
        "clusterItemDataGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void clusterItemListGet(ISigAcceptor<SigClusterItemList> sigAcceptor)
  {
    CallFactory.rpc.create(SigClusterItemList.class, ApiPlus.ENT_ID_GLOBAL, SN,
        "clusterItemListGet")
      .sendBearerToken()
      .get(null, sigAcceptor);
  }

  public static void healthCheck(ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "healthCheck")
      .get(null, sigAcceptor);
  }
}
