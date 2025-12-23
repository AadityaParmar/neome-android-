// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.cli

import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.app.cli.msg.MsgNeoScriptGet
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.app.cli.sig.SigNeoScriptGet

class RpcCli
{
  companion object
  {
    val SN: ServiceName = ServiceName.cli

      fun neoScriptGet(msg: MsgNeoScriptGet, sigAcceptor: ISigAcceptor<SigNeoScriptGet>)
          {
            CallFactory.rpc.create(SigNeoScriptGet::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "neoScriptGet")
              .sendBearerToken()
              .get(msg, sigAcceptor)
          }
  }
}