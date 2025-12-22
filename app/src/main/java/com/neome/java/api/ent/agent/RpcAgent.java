// neome.ai API - do not change
//
/* eslint-disable @typescript-eslint/no-unused-vars */
// noinspection UnusedGlobalSymbols,ES6UnusedImports,JSUnusedGlobalSymbols,JSUnusedLocalSymbols

package com.neome.java.api.ent.agent;

import com.neome.java.api.core.base.msg.MsgVersion;
import com.neome.java.api.ent.agent.msg.MsgAgentEntGet;
import com.neome.java.api.ent.agent.msg.MsgAgentEntUserImport;
import com.neome.java.api.ent.agent.msg.MsgGuaranteedRequestQueueId;
import com.neome.java.api.ent.agent.msg.MsgGuaranteedRequestQueueIdOffset;
import com.neome.java.api.ent.agent.msg.MsgPluginApiResponseAccept;
import com.neome.java.api.ent.agent.msg.MsgPluginWebhookResponseAccept;
import com.neome.java.api.ent.agent.sig.SigAgentEnt;
import com.neome.java.api.ent.agent.sig.SigAgentEntUserImport;
import com.neome.java.api.ent.agent.sig.SigAgentEntUserList;
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
public class RpcAgent
{
  public static final ServiceName SN = ServiceName.agent;

  public static void agentEntGet(EntId entId, MsgAgentEntGet msg,
    ISigAcceptor<SigAgentEnt> sigAcceptor)
  {
    CallFactory.rpc.create(SigAgentEnt.class, entId, SN, "agentEntGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void agentEntSpreadsheetDataGet(EntId entId, MsgEntSpreadsheetData msg,
    ISigAcceptor<SigEntSpreadsheetData> sigAcceptor)
  {
    CallFactory.rpc.create(SigEntSpreadsheetData.class, entId, SN, "agentEntSpreadsheetDataGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void agentEntSpreadsheetPartitionRowIdListGet(EntId entId,
    MsgEntSpreadsheetPartitionRowIdList msg,
    ISigAcceptor<SigEntSpreadsheetPartitionRowIdList> sigAcceptor)
  {
    CallFactory.rpc.create(SigEntSpreadsheetPartitionRowIdList.class, entId, SN,
        "agentEntSpreadsheetPartitionRowIdListGet")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void agentEntSpreadsheetStateGet(EntId entId, MsgEntSpreadsheetState msg,
    ISigAcceptor<SigEntSpreadsheetState> sigAcceptor)
  {
    CallFactory.rpc.create(SigEntSpreadsheetState.class, entId, SN, "agentEntSpreadsheetStateGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void agentEntUserImport(EntId entId, MsgAgentEntUserImport msg,
    ISigAcceptor<SigAgentEntUserImport> sigAcceptor)
  {
    CallFactory.rpc.create(SigAgentEntUserImport.class, entId, SN, "agentEntUserImport")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void agentEntUserListGet(EntId entId, MsgVersion msg,
    ISigAcceptor<SigAgentEntUserList> sigAcceptor)
  {
    CallFactory.rpc.create(SigAgentEntUserList.class, entId, SN, "agentEntUserListGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void guaranteedRequestListGet(MsgGuaranteedRequestQueueId msg,
    ISigAcceptor<SigGuaranteedRequestListGet> sigAcceptor)
  {
    CallFactory.rpc.create(SigGuaranteedRequestListGet.class, ApiPlus.ENT_ID_GLOBAL, SN,
        "guaranteedRequestListGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void guaranteedRequestMarkRead(MsgGuaranteedRequestQueueIdOffset msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "guaranteedRequestMarkRead")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void pluginApiResponseAccept(MsgPluginApiResponseAccept msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "pluginApiResponseAccept")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void pluginWebhookResponseAccept(MsgPluginWebhookResponseAccept msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "pluginWebhookResponseAccept")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }
}
