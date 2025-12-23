// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.ent

import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.ent.ent.msg.MsgDemoApp
import com.neome.api.ent.ent.msg.MsgEntSpreadsheetData
import com.neome.api.ent.ent.msg.MsgEntSpreadsheetPartitionRowIdList
import com.neome.api.ent.ent.msg.MsgEntSpreadsheetState
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.ent.ent.sig.SigDemoApp
import com.neome.api.ent.ent.sig.SigEntSpreadsheetData
import com.neome.api.ent.ent.sig.SigEntSpreadsheetPartitionRowIdList
import com.neome.api.ent.ent.sig.SigEntSpreadsheetState

class RpcEnt
{
  companion object
  {
    val SN: ServiceName = ServiceName.ent

      fun demoAppGet(msg: MsgDemoApp, sigAcceptor: ISigAcceptor<SigDemoApp>)
          {
            CallFactory.rpc.create(SigDemoApp::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "demoAppGet")
              .get(msg, sigAcceptor)
          }

      fun entSpreadsheetDataGet(entId: EntId, msg: MsgEntSpreadsheetData, sigAcceptor: ISigAcceptor<SigEntSpreadsheetData>)
          {
            CallFactory.rpc.create(SigEntSpreadsheetData::class.java, entId, SN, "entSpreadsheetDataGet")
              .sendBearerToken()
              .get(msg, sigAcceptor)
          }

      fun entSpreadsheetPartitionRowIdListGet(entId: EntId, msg: MsgEntSpreadsheetPartitionRowIdList, sigAcceptor: ISigAcceptor<SigEntSpreadsheetPartitionRowIdList>)
          {
            CallFactory.rpc.create(SigEntSpreadsheetPartitionRowIdList::class.java, entId, SN, "entSpreadsheetPartitionRowIdListGet")
              .sendBearerToken()
              .post(msg, sigAcceptor)
          }

      fun entSpreadsheetStateGet(entId: EntId, msg: MsgEntSpreadsheetState, sigAcceptor: ISigAcceptor<SigEntSpreadsheetState>)
          {
            CallFactory.rpc.create(SigEntSpreadsheetState::class.java, entId, SN, "entSpreadsheetStateGet")
              .sendBearerToken()
              .get(msg, sigAcceptor)
          }
  }
}