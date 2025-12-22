// neome.ai API - do not change
//
/* eslint-disable @typescript-eslint/no-unused-vars */
// noinspection UnusedGlobalSymbols,ES6UnusedImports,JSUnusedGlobalSymbols,JSUnusedLocalSymbols

package com.neome.java.api.ent.ent;

import com.neome.java.api.ent.ent.msg.MsgDemoApp;
import com.neome.java.api.ent.ent.msg.MsgEntSpreadsheetData;
import com.neome.java.api.ent.ent.msg.MsgEntSpreadsheetPartitionRowIdList;
import com.neome.java.api.ent.ent.msg.MsgEntSpreadsheetState;
import com.neome.java.api.ent.ent.sig.SigDemoApp;
import com.neome.java.api.ent.ent.sig.SigEntSpreadsheetData;
import com.neome.java.api.ent.ent.sig.SigEntSpreadsheetPartitionRowIdList;
import com.neome.java.api.ent.ent.sig.SigEntSpreadsheetState;
import com.neome.java.api.meta.base.Types.EntId;
import com.neome.java.api.meta.base.Types.ServiceName;
import com.neome.java.api.nucleus.base.ApiPlus;
import com.neome.java.api.nucleus.base.CallFactory;
import com.neome.java.api.nucleus.base.ISigAcceptor;

@SuppressWarnings("unused")
public class RpcEnt
{
  public static final ServiceName SN = ServiceName.ent;

  public static void demoAppGet(MsgDemoApp msg, ISigAcceptor<SigDemoApp> sigAcceptor)
  {
    CallFactory.rpc.create(SigDemoApp.class, ApiPlus.ENT_ID_GLOBAL, SN, "demoAppGet")
      .get(msg, sigAcceptor);
  }

  public static void entSpreadsheetDataGet(EntId entId, MsgEntSpreadsheetData msg,
    ISigAcceptor<SigEntSpreadsheetData> sigAcceptor)
  {
    CallFactory.rpc.create(SigEntSpreadsheetData.class, entId, SN, "entSpreadsheetDataGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void entSpreadsheetPartitionRowIdListGet(EntId entId,
    MsgEntSpreadsheetPartitionRowIdList msg,
    ISigAcceptor<SigEntSpreadsheetPartitionRowIdList> sigAcceptor)
  {
    CallFactory.rpc.create(SigEntSpreadsheetPartitionRowIdList.class, entId, SN,
        "entSpreadsheetPartitionRowIdListGet")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void entSpreadsheetStateGet(EntId entId, MsgEntSpreadsheetState msg,
    ISigAcceptor<SigEntSpreadsheetState> sigAcceptor)
  {
    CallFactory.rpc.create(SigEntSpreadsheetState.class, entId, SN, "entSpreadsheetStateGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }
}
