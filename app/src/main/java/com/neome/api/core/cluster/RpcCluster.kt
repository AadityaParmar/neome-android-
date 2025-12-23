// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.cluster

import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.core.cluster.msg.MsgClusterItemDataGet
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.core.cluster.sig.SigClusterItemData
import com.neome.api.core.cluster.sig.SigClusterItemList
import com.neome.api.nucleus.base.sig.SigDone

class RpcCluster
{
  companion object
  {
    val SN: ServiceName = ServiceName.cluster

      fun clusterItemDataGet(msg: MsgClusterItemDataGet, sigAcceptor: ISigAcceptor<SigClusterItemData>)
          {
            CallFactory.rpc.create(SigClusterItemData::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "clusterItemDataGet")
              .sendBearerToken()
              .get(msg, sigAcceptor)
          }

      fun clusterItemListGet(sigAcceptor: ISigAcceptor<SigClusterItemList>)
          {
            CallFactory.rpc.create(SigClusterItemList::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "clusterItemListGet")
              .sendBearerToken()
              .get(null, sigAcceptor)
          }

      fun healthCheck(sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.rpc.create(SigDone::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "healthCheck")
              .get(null, sigAcceptor)
          }
  }
}