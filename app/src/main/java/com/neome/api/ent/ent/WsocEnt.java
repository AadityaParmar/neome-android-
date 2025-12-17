// neome.ai API - do not change
//
/* eslint-disable @typescript-eslint/no-unused-vars */
// noinspection UnusedGlobalSymbols,ES6UnusedImports,JSUnusedGlobalSymbols,JSUnusedLocalSymbols

package com.neome.api.ent.ent;

import com.neome.api.ent.ent.msg.MsgEntSpreadsheetData;
import com.neome.api.ent.ent.msg.MsgEntSpreadsheetPartitionRowIdList;
import com.neome.api.ent.ent.msg.MsgEntSpreadsheetState;
import com.neome.api.ent.ent.sig.SigEntSpreadsheetData;
import com.neome.api.ent.ent.sig.SigEntSpreadsheetPartitionRowIdList;
import com.neome.api.ent.ent.sig.SigEntSpreadsheetState;
import com.neome.api.meta.base.Types.EntId;
import com.neome.api.meta.base.Types.ServiceName;
import com.neome.api.nucleus.base.CallFactory;
import com.neome.api.nucleus.base.ISigAcceptor;

@SuppressWarnings("unused")
public class WsocEnt
{
  public static final ServiceName SN = ServiceName.ent;

  public static void entSpreadsheetDataGet(EntId entId, MsgEntSpreadsheetData msg,
    ISigAcceptor<SigEntSpreadsheetData> sigAcceptor)
  {
    CallFactory.wsoc.create(SigEntSpreadsheetData.class, entId, SN, "entSpreadsheetDataGet")
      .get(msg, sigAcceptor);
  }

  public static void entSpreadsheetPartitionRowIdListGet(EntId entId,
    MsgEntSpreadsheetPartitionRowIdList msg,
    ISigAcceptor<SigEntSpreadsheetPartitionRowIdList> sigAcceptor)
  {
    CallFactory.wsoc.create(SigEntSpreadsheetPartitionRowIdList.class, entId, SN,
        "entSpreadsheetPartitionRowIdListGet")
      .post(msg, sigAcceptor);
  }

  public static void entSpreadsheetStateGet(EntId entId, MsgEntSpreadsheetState msg,
    ISigAcceptor<SigEntSpreadsheetState> sigAcceptor)
  {
    CallFactory.wsoc.create(SigEntSpreadsheetState.class, entId, SN, "entSpreadsheetStateGet")
      .get(msg, sigAcceptor);
  }
}
