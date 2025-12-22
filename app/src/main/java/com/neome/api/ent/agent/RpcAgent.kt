// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.agent

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.ent.agent.msg.MsgAgentEntGet
import com.neome.api.ent.agent.msg.MsgAgentEntUserImport
import com.neome.api.ent.agent.msg.MsgGuaranteedRequestQueueId
import com.neome.api.ent.agent.msg.MsgGuaranteedRequestQueueIdOffset
import com.neome.api.ent.agent.msg.MsgPluginApiResponseAccept
import com.neome.api.ent.agent.msg.MsgPluginWebhookResponseAccept
import com.neome.api.ent.agent.sig.SigAgentEnt
import com.neome.api.ent.agent.sig.SigAgentEntUserImport
import com.neome.api.ent.agent.sig.SigAgentEntUserList
import com.neome.api.ent.agent.sig.SigGuaranteedRequestListGet
import com.neome.api.ent.ent.msg.MsgEntSpreadsheetData
import com.neome.api.ent.ent.msg.MsgEntSpreadsheetPartitionRowIdList
import com.neome.api.ent.ent.msg.MsgEntSpreadsheetState
import com.neome.api.ent.ent.sig.SigEntSpreadsheetData
import com.neome.api.ent.ent.sig.SigEntSpreadsheetPartitionRowIdList
import com.neome.api.ent.ent.sig.SigEntSpreadsheetState
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.nucleus.base.sig.SigDone

class RpcAgent {
    companion object {
        val SN: ServiceName = ServiceName.agent

        fun agentEntGet(entId: EntId, msg: MsgAgentEntGet, sigAcceptor: ISigAcceptor<SigAgentEnt>) {
            CallFactory.rpc.create(SigAgentEnt::class.java, entId, SN, "agentEntGet")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun agentEntSpreadsheetDataGet(
            entId: EntId,
            msg: MsgEntSpreadsheetData,
            sigAcceptor: ISigAcceptor<SigEntSpreadsheetData>
        ) {
            CallFactory.rpc.create(
                SigEntSpreadsheetData::class.java,
                entId,
                SN,
                "agentEntSpreadsheetDataGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun agentEntSpreadsheetPartitionRowIdListGet(
            entId: EntId,
            msg: MsgEntSpreadsheetPartitionRowIdList,
            sigAcceptor: ISigAcceptor<SigEntSpreadsheetPartitionRowIdList>
        ) {
            CallFactory.rpc.create(
                SigEntSpreadsheetPartitionRowIdList::class.java,
                entId,
                SN,
                "agentEntSpreadsheetPartitionRowIdListGet"
            )
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun agentEntSpreadsheetStateGet(
            entId: EntId,
            msg: MsgEntSpreadsheetState,
            sigAcceptor: ISigAcceptor<SigEntSpreadsheetState>
        ) {
            CallFactory.rpc.create(
                SigEntSpreadsheetState::class.java,
                entId,
                SN,
                "agentEntSpreadsheetStateGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun agentEntUserImport(
            entId: EntId,
            msg: MsgAgentEntUserImport,
            sigAcceptor: ISigAcceptor<SigAgentEntUserImport>
        ) {
            CallFactory.rpc.create(
                SigAgentEntUserImport::class.java,
                entId,
                SN,
                "agentEntUserImport"
            )
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun agentEntUserListGet(
            entId: EntId,
            msg: MsgVersion,
            sigAcceptor: ISigAcceptor<SigAgentEntUserList>
        ) {
            CallFactory.rpc.create(
                SigAgentEntUserList::class.java,
                entId,
                SN,
                "agentEntUserListGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun guaranteedRequestListGet(
            msg: MsgGuaranteedRequestQueueId,
            sigAcceptor: ISigAcceptor<SigGuaranteedRequestListGet>
        ) {
            CallFactory.rpc.create(
                SigGuaranteedRequestListGet::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "guaranteedRequestListGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun guaranteedRequestMarkRead(
            msg: MsgGuaranteedRequestQueueIdOffset,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(
                SigDone::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "guaranteedRequestMarkRead"
            )
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun pluginApiResponseAccept(
            msg: MsgPluginApiResponseAccept,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(
                SigDone::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "pluginApiResponseAccept"
            )
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun pluginWebhookResponseAccept(
            msg: MsgPluginWebhookResponseAccept,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(
                SigDone::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "pluginWebhookResponseAccept"
            )
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }
    }
}
