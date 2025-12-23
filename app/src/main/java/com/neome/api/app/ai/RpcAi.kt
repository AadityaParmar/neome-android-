// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.ai

import com.neome.api.nucleus.base.CallFactory
import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.app.ai.msg.MsgAiNeoQLGet
import com.neome.api.app.ai.msg.MsgAiNeoQLValidate
import com.neome.api.app.ai.msg.MsgAiNeoScriptGen
import com.neome.api.app.ai.msg.MsgAiNeoScriptGet
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.app.ai.sig.SigAiNeoQLGet
import com.neome.api.app.ai.sig.SigAiNeoQLValidate
import com.neome.api.app.ai.sig.SigAiNeoScriptGen
import com.neome.api.app.ai.sig.SigAiNeoScriptGet

class RpcAi
{
  companion object
  {
    val SN: ServiceName = ServiceName.ai

      fun aiNeoQLGet(entId: EntId, msg: MsgAiNeoQLGet, sigAcceptor: ISigAcceptor<SigAiNeoQLGet>)
          {
            CallFactory.rpc.create(SigAiNeoQLGet::class.java, entId, SN, "aiNeoQLGet")
              .sendBearerToken()
              .post(msg, sigAcceptor)
          }

      fun aiNeoQLValidate(entId: EntId, msg: MsgAiNeoQLValidate, sigAcceptor: ISigAcceptor<SigAiNeoQLValidate>)
          {
            CallFactory.rpc.create(SigAiNeoQLValidate::class.java, entId, SN, "aiNeoQLValidate")
              .sendBearerToken()
              .post(msg, sigAcceptor)
          }

      fun aiNeoScriptGen(entId: EntId, msg: MsgAiNeoScriptGen, sigAcceptor: ISigAcceptor<SigAiNeoScriptGen>)
          {
            CallFactory.rpc.create(SigAiNeoScriptGen::class.java, entId, SN, "aiNeoScriptGen")
              .sendBearerToken()
              .post(msg, sigAcceptor)
          }

      fun aiNeoScriptGet(entId: EntId, msg: MsgAiNeoScriptGet, sigAcceptor: ISigAcceptor<SigAiNeoScriptGet>)
          {
            CallFactory.rpc.create(SigAiNeoScriptGet::class.java, entId, SN, "aiNeoScriptGet")
              .sendBearerToken()
              .post(msg, sigAcceptor)
          }
  }
}