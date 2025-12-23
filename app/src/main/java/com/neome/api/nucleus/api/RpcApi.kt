// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.api

import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.nucleus.api.sig.SigApiCode
import com.neome.api.nucleus.api.sig.SigApiLib
import com.neome.api.nucleus.api.sig.SigClassTree

class RpcApi
{
  companion object
  {
    val SN: ServiceName = ServiceName.api

      fun apiCodeGet(sigAcceptor: ISigAcceptor<SigApiCode>)
          {
            CallFactory.rpc.create(SigApiCode::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "apiCodeGet")
              .sendBearerToken()
              .get(null, sigAcceptor)
          }

      fun apiListGet(sigAcceptor: ISigAcceptor<SigApiLib>)
          {
            CallFactory.rpc.create(SigApiLib::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "apiListGet")
              .sendBearerToken()
              .get(null, sigAcceptor)
          }

      fun sysIdTreeGet(sigAcceptor: ISigAcceptor<SigClassTree>)
          {
            CallFactory.rpc.create(SigClassTree::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "sysIdTreeGet")
              .sendBearerToken()
              .get(null, sigAcceptor)
          }
  }
}