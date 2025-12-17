// neome.ai API - do not change
//
/* eslint-disable @typescript-eslint/no-unused-vars */
// noinspection UnusedGlobalSymbols,ES6UnusedImports,JSUnusedGlobalSymbols,JSUnusedLocalSymbols

package com.neome.api.core.task;

import com.neome.api.core.task.msg.MsgTaskId;
import com.neome.api.core.task.sig.SigTask;
import com.neome.api.meta.base.Types.ServiceName;
import com.neome.api.nucleus.base.ApiPlus;
import com.neome.api.nucleus.base.CallFactory;
import com.neome.api.nucleus.base.ISigAcceptor;

@SuppressWarnings("unused")
public class RpcTask
{
  public static final ServiceName SN = ServiceName.task;

  public static void getTaskStatus(MsgTaskId msg, ISigAcceptor<SigTask> sigAcceptor)
  {
    CallFactory.rpc.create(SigTask.class, ApiPlus.ENT_ID_GLOBAL, SN, "getTaskStatus")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }
}
