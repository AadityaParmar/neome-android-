// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.ent

import com.neome.api.ent.ent.msg.MsgEntSpreadsheetData
import com.neome.api.ent.ent.msg.MsgEntSpreadsheetPartitionRowIdList
import com.neome.api.ent.ent.msg.MsgEntSpreadsheetState
import com.neome.api.ent.ent.sig.SigEntSpreadsheetData
import com.neome.api.ent.ent.sig.SigEntSpreadsheetPartitionRowIdList
import com.neome.api.ent.ent.sig.SigEntSpreadsheetState
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ISigAcceptor

class WsocEnt {
    companion object {
        val SN: ServiceName = ServiceName.ent

        fun entSpreadsheetDataGet(
            entId: EntId,
            msg: MsgEntSpreadsheetData,
            sigAcceptor: ISigAcceptor<SigEntSpreadsheetData>
        ) {
            CallFactory.wsoc.create(
                SigEntSpreadsheetData::class.java,
                entId,
                SN,
                "entSpreadsheetDataGet"
            )
                .get(msg, sigAcceptor)
        }

        fun entSpreadsheetPartitionRowIdListGet(
            entId: EntId,
            msg: MsgEntSpreadsheetPartitionRowIdList,
            sigAcceptor: ISigAcceptor<SigEntSpreadsheetPartitionRowIdList>
        ) {
            CallFactory.wsoc.create(
                SigEntSpreadsheetPartitionRowIdList::class.java,
                entId,
                SN,
                "entSpreadsheetPartitionRowIdListGet"
            )
                .post(msg, sigAcceptor)
        }

        fun entSpreadsheetStateGet(
            entId: EntId,
            msg: MsgEntSpreadsheetState,
            sigAcceptor: ISigAcceptor<SigEntSpreadsheetState>
        ) {
            CallFactory.wsoc.create(
                SigEntSpreadsheetState::class.java,
                entId,
                SN,
                "entSpreadsheetStateGet"
            )
                .get(msg, sigAcceptor)
        }
    }
}
