// neome.ai API - do not change
//
/* eslint-disable @typescript-eslint/no-unused-vars */
// noinspection UnusedGlobalSymbols,ES6UnusedImports,JSUnusedGlobalSymbols,JSUnusedLocalSymbols

package com.neome.java.api.ent.entAside;

import com.neome.java.api.core.base.msg.MsgVersion;
import com.neome.java.api.ent.entAside.msg.MsgButtonFieldReportDataGet;
import com.neome.java.api.ent.entAside.msg.MsgEntLogNumberFieldDataGet;
import com.neome.java.api.ent.entAside.msg.MsgEntUserPickerCandidateListGet;
import com.neome.java.api.ent.entAside.msg.MsgPluginApiOutput;
import com.neome.java.api.ent.entAside.msg.MsgRefFieldDataPaginatedGet;
import com.neome.java.api.ent.entAside.msg.MsgReportFieldDataGet;
import com.neome.java.api.ent.entAside.msg.MsgSpreadsheetRefFieldDataGet;
import com.neome.java.api.ent.entAside.sig.SigEntInfo;
import com.neome.java.api.ent.entAside.sig.SigEntLogNumberFieldDataGet;
import com.neome.java.api.ent.entAside.sig.SigEntUserPickerCandidateListGet;
import com.neome.java.api.ent.entAside.sig.SigPluginApiOutput;
import com.neome.java.api.ent.entAside.sig.SigReportFieldData;
import com.neome.java.api.ent.entAside.sig.SigSpreadsheetRefFieldData;
import com.neome.java.api.ent.entMain.sig.SigOutputFormValue;
import com.neome.java.api.ent.entMain.sig.SigSpreadsheetRowsPage;
import com.neome.java.api.meta.base.Types.EntId;
import com.neome.java.api.meta.base.Types.ServiceName;
import com.neome.java.api.nucleus.base.CallFactory;
import com.neome.java.api.nucleus.base.ISigAcceptor;

@SuppressWarnings("unused")
public class WsocEntAside
{
  public static final ServiceName SN = ServiceName.entAside;

  public static void entButtonFieldReportDataGet(EntId entId, MsgButtonFieldReportDataGet msg,
    ISigAcceptor<SigOutputFormValue> sigAcceptor)
  {
    CallFactory.wsoc.create(SigOutputFormValue.class, entId, SN, "entButtonFieldReportDataGet")
      .post(msg, sigAcceptor);
  }

  public static void entInfoGet(EntId entId, MsgVersion msg, ISigAcceptor<SigEntInfo> sigAcceptor)
  {
    CallFactory.wsoc.create(SigEntInfo.class, entId, SN, "entInfoGet")
      .get(msg, sigAcceptor);
  }

  public static void entLogNumberFieldDataGet(EntId entId, MsgEntLogNumberFieldDataGet msg,
    ISigAcceptor<SigEntLogNumberFieldDataGet> sigAcceptor)
  {
    CallFactory.wsoc.create(SigEntLogNumberFieldDataGet.class, entId, SN,
        "entLogNumberFieldDataGet")
      .get(msg, sigAcceptor);
  }

  public static void entRefFieldPaginatedDataGet(EntId entId, MsgRefFieldDataPaginatedGet msg,
    ISigAcceptor<SigSpreadsheetRowsPage> sigAcceptor)
  {
    CallFactory.wsoc.create(SigSpreadsheetRowsPage.class, entId, SN, "entRefFieldPaginatedDataGet")
      .post(msg, sigAcceptor);
  }

  public static void entReportFieldDataGet(EntId entId, MsgReportFieldDataGet msg,
    ISigAcceptor<SigReportFieldData> sigAcceptor)
  {
    CallFactory.wsoc.create(SigReportFieldData.class, entId, SN, "entReportFieldDataGet")
      .post(msg, sigAcceptor);
  }

  public static void entSpreadsheetRefFieldDataGet(EntId entId, MsgSpreadsheetRefFieldDataGet msg,
    ISigAcceptor<SigSpreadsheetRefFieldData> sigAcceptor)
  {
    CallFactory.wsoc.create(SigSpreadsheetRefFieldData.class, entId, SN,
        "entSpreadsheetRefFieldDataGet")
      .post(msg, sigAcceptor);
  }

  public static void entUserPickerCandidateListGet(EntId entId,
    MsgEntUserPickerCandidateListGet msg,
    ISigAcceptor<SigEntUserPickerCandidateListGet> sigAcceptor)
  {
    CallFactory.wsoc.create(SigEntUserPickerCandidateListGet.class, entId, SN,
        "entUserPickerCandidateListGet")
      .post(msg, sigAcceptor);
  }

  public static void pluginApiOutputGet(EntId entId, MsgPluginApiOutput msg,
    ISigAcceptor<SigPluginApiOutput> sigAcceptor)
  {
    CallFactory.wsoc.create(SigPluginApiOutput.class, entId, SN, "pluginApiOutputGet")
      .post(msg, sigAcceptor);
  }
}
