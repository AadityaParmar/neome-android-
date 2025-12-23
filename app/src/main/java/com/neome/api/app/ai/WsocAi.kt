// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.ai

import com.neome.api.nucleus.base.CallFactory
import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.app.ai.msg.MsgAiNeoQLGet
import com.neome.api.app.ai.msg.MsgAiNeoQLValidate
import com.neome.api.app.ai.msg.MsgAiNeoScriptGet
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.app.ai.sig.SigAiNeoQLGet
import com.neome.api.app.ai.sig.SigAiNeoQLValidate
import com.neome.api.app.ai.sig.SigAiNeoScriptGet

class WsocAi
{
  companion object
  {
    val SN: ServiceName = ServiceName.ai

      fun aiNeoQLGet(entId: EntId, msg: MsgAiNeoQLGet, sigAcceptor: ISigAcceptor<SigAiNeoQLGet>)
          {
            CallFactory.wsoc.create(SigAiNeoQLGet::class.java, entId, SN, "aiNeoQLGet")
              .post(msg, sigAcceptor)
          }

      fun aiNeoQLValidate(entId: EntId, msg: MsgAiNeoQLValidate, sigAcceptor: ISigAcceptor<SigAiNeoQLValidate>)
          {
            CallFactory.wsoc.create(SigAiNeoQLValidate::class.java, entId, SN, "aiNeoQLValidate")
              .post(msg, sigAcceptor)
          }

      fun aiNeoScriptGet(entId: EntId, msg: MsgAiNeoScriptGet, sigAcceptor: ISigAcceptor<SigAiNeoScriptGet>)
          {
            CallFactory.wsoc.create(SigAiNeoScriptGet::class.java, entId, SN, "aiNeoScriptGet")
              .post(msg, sigAcceptor)
          }
  }
}