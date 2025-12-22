// neome.ai API - do not change
//
/* eslint-disable @typescript-eslint/no-unused-vars */
// noinspection UnusedGlobalSymbols,ES6UnusedImports,JSUnusedGlobalSymbols,JSUnusedLocalSymbols

package com.neome.java.api.ent.agent;

import com.neome.java.api.ent.agent.msg.MsgAgentActiveStatusUpdate;
import com.neome.java.api.ent.agent.msg.MsgAgentEntGet;
import com.neome.java.api.ent.agent.msg.MsgGuaranteedRequestQueueId;
import com.neome.java.api.ent.agent.msg.MsgGuaranteedRequestQueueIdOffset;
import com.neome.java.api.ent.agent.msg.MsgPluginApiResponseAccept;
import com.neome.java.api.ent.agent.msg.MsgPluginWebhookResponseAccept;
import com.neome.java.api.ent.agent.sig.SigAgentEnt;
import com.neome.java.api.ent.agent.sig.SigGuaranteedRequestListGet;
import com.neome.java.api.ent.ent.msg.MsgEntSpreadsheetData;
import com.neome.java.api.ent.ent.msg.MsgEntSpreadsheetPartitionRowIdList;
import com.neome.java.api.ent.ent.msg.MsgEntSpreadsheetState;
import com.neome.java.api.ent.ent.sig.SigEntSpreadsheetData;
import com.neome.java.api.ent.ent.sig.SigEntSpreadsheetPartitionRowIdList;
import com.neome.java.api.ent.ent.sig.SigEntSpreadsheetState;
import com.neome.java.api.meta.base.Types.EntId;
import com.neome.java.api.meta.base.Types.ServiceName;
import com.neome.java.api.nucleus.base.ApiPlus;
import com.neome.java.api.nucleus.base.CallFactory;
import com.neome.java.api.nucleus.base.ISigAcceptor;
import com.neome.java.api.nucleus.base.sig.SigDone;

@SuppressWarnings("unused")
public class WsocAgent
{
  public static final ServiceName SN = ServiceName.agent;

  public static void agentEntActiveStatusUpdate(MsgAgentActiveStatusUpdate msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "agentEntActiveStatusUpdate")
      .put(msg, sigAcceptor);
  }

  public static void agentEntGet(EntId entId, MsgAgentEntGet msg,
    ISigAcceptor<SigAgentEnt> sigAcceptor)
  {
    CallFactory.wsoc.create(SigAgentEnt.class, entId, SN, "agentEntGet")
      .get(msg, sigAcceptor);
  }

  public static void agentEntSpreadsheetDataGet(EntId entId, MsgEntSpreadsheetData msg,
    ISigAcceptor<SigEntSpreadsheetData> sigAcceptor)
  {
    CallFactory.wsoc.create(SigEntSpreadsheetData.class, entId, SN, "agentEntSpreadsheetDataGet")
      .get(msg, sigAcceptor);
  }

  public static void agentEntSpreadsheetPartitionRowIdListGet(EntId entId,
    MsgEntSpreadsheetPartitionRowIdList msg,
    ISigAcceptor<SigEntSpreadsheetPartitionRowIdList> sigAcceptor)
  {
    CallFactory.wsoc.create(SigEntSpreadsheetPartitionRowIdList.class, entId, SN,
        "agentEntSpreadsheetPartitionRowIdListGet")
      .post(msg, sigAcceptor);
  }

  public static void agentEntSpreadsheetStateGet(EntId entId, MsgEntSpreadsheetState msg,
    ISigAcceptor<SigEntSpreadsheetState> sigAcceptor)
  {
    CallFactory.wsoc.create(SigEntSpreadsheetState.class, entId, SN, "agentEntSpreadsheetStateGet")
      .get(msg, sigAcceptor);
  }

  public static void guaranteedRequestListGet(MsgGuaranteedRequestQueueId msg,
    ISigAcceptor<SigGuaranteedRequestListGet> sigAcceptor)
  {
    CallFactory.wsoc.create(SigGuaranteedRequestListGet.class, ApiPlus.ENT_ID_GLOBAL, SN,
        "guaranteedRequestListGet")
      .get(msg, sigAcceptor);
  }

  public static void guaranteedRequestMarkRead(MsgGuaranteedRequestQueueIdOffset msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "guaranteedRequestMarkRead")
      .post(msg, sigAcceptor);
  }

  public static void pluginApiResponseAccept(MsgPluginApiResponseAccept msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "pluginApiResponseAccept")
      .post(msg, sigAcceptor);
  }

  public static void pluginWebhookResponseAccept(MsgPluginWebhookResponseAccept msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "pluginWebhookResponseAccept")
      .post(msg, sigAcceptor);
  }
}
