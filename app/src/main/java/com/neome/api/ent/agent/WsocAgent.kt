// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.agent

import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.ent.agent.msg.MsgAgentActiveStatusUpdate
import com.neome.api.ent.agent.msg.MsgAgentEntGet
import com.neome.api.ent.ent.msg.MsgEntSpreadsheetData
import com.neome.api.ent.ent.msg.MsgEntSpreadsheetPartitionRowIdList
import com.neome.api.ent.ent.msg.MsgEntSpreadsheetState
import com.neome.api.ent.agent.msg.MsgGuaranteedRequestQueueId
import com.neome.api.ent.agent.msg.MsgGuaranteedRequestQueueIdOffset
import com.neome.api.ent.agent.msg.MsgPluginApiResponseAccept
import com.neome.api.ent.agent.msg.MsgPluginWebhookResponseAccept
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.ent.agent.sig.SigAgentEnt
import com.neome.api.nucleus.base.sig.SigDone
import com.neome.api.ent.ent.sig.SigEntSpreadsheetData
import com.neome.api.ent.ent.sig.SigEntSpreadsheetPartitionRowIdList
import com.neome.api.ent.ent.sig.SigEntSpreadsheetState
import com.neome.api.ent.agent.sig.SigGuaranteedRequestListGet

class WsocAgent
{
  companion object
  {
    val SN: ServiceName = ServiceName.agent

      fun agentEntActiveStatusUpdate(msg: MsgAgentActiveStatusUpdate, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.wsoc.create(SigDone::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "agentEntActiveStatusUpdate")
              .put(msg, sigAcceptor)
          }

      fun agentEntGet(entId: EntId, msg: MsgAgentEntGet, sigAcceptor: ISigAcceptor<SigAgentEnt>)
          {
            CallFactory.wsoc.create(SigAgentEnt::class.java, entId, SN, "agentEntGet")
              .get(msg, sigAcceptor)
          }

      fun agentEntSpreadsheetDataGet(entId: EntId, msg: MsgEntSpreadsheetData, sigAcceptor: ISigAcceptor<SigEntSpreadsheetData>)
          {
            CallFactory.wsoc.create(SigEntSpreadsheetData::class.java, entId, SN, "agentEntSpreadsheetDataGet")
              .get(msg, sigAcceptor)
          }

      fun agentEntSpreadsheetPartitionRowIdListGet(entId: EntId, msg: MsgEntSpreadsheetPartitionRowIdList, sigAcceptor: ISigAcceptor<SigEntSpreadsheetPartitionRowIdList>)
          {
            CallFactory.wsoc.create(SigEntSpreadsheetPartitionRowIdList::class.java, entId, SN, "agentEntSpreadsheetPartitionRowIdListGet")
              .post(msg, sigAcceptor)
          }

      fun agentEntSpreadsheetStateGet(entId: EntId, msg: MsgEntSpreadsheetState, sigAcceptor: ISigAcceptor<SigEntSpreadsheetState>)
          {
            CallFactory.wsoc.create(SigEntSpreadsheetState::class.java, entId, SN, "agentEntSpreadsheetStateGet")
              .get(msg, sigAcceptor)
          }

      fun guaranteedRequestListGet(msg: MsgGuaranteedRequestQueueId, sigAcceptor: ISigAcceptor<SigGuaranteedRequestListGet>)
          {
            CallFactory.wsoc.create(SigGuaranteedRequestListGet::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "guaranteedRequestListGet")
              .get(msg, sigAcceptor)
          }

      fun guaranteedRequestMarkRead(msg: MsgGuaranteedRequestQueueIdOffset, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.wsoc.create(SigDone::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "guaranteedRequestMarkRead")
              .post(msg, sigAcceptor)
          }

      fun pluginApiResponseAccept(msg: MsgPluginApiResponseAccept, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.wsoc.create(SigDone::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "pluginApiResponseAccept")
              .post(msg, sigAcceptor)
          }

      fun pluginWebhookResponseAccept(msg: MsgPluginWebhookResponseAccept, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.wsoc.create(SigDone::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "pluginWebhookResponseAccept")
              .post(msg, sigAcceptor)
          }
  }
}