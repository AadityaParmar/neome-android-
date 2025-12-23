// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.task

import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.core.task.msg.MsgTaskId
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.core.task.sig.SigTask

class RpcTask
{
  companion object
  {
    val SN: ServiceName = ServiceName.task

      fun getTaskStatus(msg: MsgTaskId, sigAcceptor: ISigAcceptor<SigTask>)
          {
            CallFactory.rpc.create(SigTask::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "getTaskStatus")
              .sendBearerToken()
              .get(msg, sigAcceptor)
          }
  }
}