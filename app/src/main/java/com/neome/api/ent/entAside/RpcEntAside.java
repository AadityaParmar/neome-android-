// neome.ai API - do not change
//
/* eslint-disable @typescript-eslint/no-unused-vars */
// noinspection UnusedGlobalSymbols,ES6UnusedImports,JSUnusedGlobalSymbols,JSUnusedLocalSymbols

package com.neome.api.ent.entAside;

import com.neome.api.core.base.msg.MsgVersion;
import com.neome.api.ent.entAside.msg.MsgButtonFieldReportDataGet;
import com.neome.api.ent.entAside.msg.MsgEntLogNumberFieldDataGet;
import com.neome.api.ent.entAside.msg.MsgEntUserPickerCandidateListGet;
import com.neome.api.ent.entAside.msg.MsgPaymentStatus;
import com.neome.api.ent.entAside.msg.MsgPaymentVerify;
import com.neome.api.ent.entAside.msg.MsgPluginApiOutput;
import com.neome.api.ent.entAside.msg.MsgRefFieldDataPaginatedGet;
import com.neome.api.ent.entAside.msg.MsgReportFieldDataGet;
import com.neome.api.ent.entAside.msg.MsgSpreadsheetRefFieldDataGet;
import com.neome.api.ent.entAside.msg.MsgSpreadsheetRowsGet;
import com.neome.api.ent.entAside.sig.SigEntInfo;
import com.neome.api.ent.entAside.sig.SigEntLogNumberFieldDataGet;
import com.neome.api.ent.entAside.sig.SigEntUserPickerCandidateListGet;
import com.neome.api.ent.entAside.sig.SigPaymentStatus;
import com.neome.api.ent.entAside.sig.SigPluginApiOutput;
import com.neome.api.ent.entAside.sig.SigReportFieldData;
import com.neome.api.ent.entAside.sig.SigSpreadsheetRefFieldData;
import com.neome.api.ent.entAside.sig.SigSpreadsheetRowsGet;
import com.neome.api.ent.entMain.sig.SigOutputFormValue;
import com.neome.api.ent.entMain.sig.SigSpreadsheetRowsPage;
import com.neome.api.meta.base.Types.EntId;
import com.neome.api.meta.base.Types.ServiceName;
import com.neome.api.nucleus.base.CallFactory;
import com.neome.api.nucleus.base.ISigAcceptor;
import com.neome.api.nucleus.base.sig.SigDone;

@SuppressWarnings("unused")
public class RpcEntAside
{
  public static final ServiceName SN = ServiceName.entAside;

  public static void entButtonFieldReportDataGet(EntId entId, MsgButtonFieldReportDataGet msg,
    ISigAcceptor<SigOutputFormValue> sigAcceptor)
  {
    CallFactory.rpc.create(SigOutputFormValue.class, entId, SN, "entButtonFieldReportDataGet")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void entInfoGet(EntId entId, MsgVersion msg, ISigAcceptor<SigEntInfo> sigAcceptor)
  {
    CallFactory.rpc.create(SigEntInfo.class, entId, SN, "entInfoGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void entLogNumberFieldDataGet(EntId entId, MsgEntLogNumberFieldDataGet msg,
    ISigAcceptor<SigEntLogNumberFieldDataGet> sigAcceptor)
  {
    CallFactory.rpc.create(SigEntLogNumberFieldDataGet.class, entId, SN, "entLogNumberFieldDataGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void entPaymentStatusGet(EntId entId, MsgPaymentStatus msg,
    ISigAcceptor<SigPaymentStatus> sigAcceptor)
  {
    CallFactory.rpc.create(SigPaymentStatus.class, entId, SN, "entPaymentStatusGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void entPaymentVerify(EntId entId, MsgPaymentVerify msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, entId, SN, "entPaymentVerify")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void entRefFieldPaginatedDataGet(EntId entId, MsgRefFieldDataPaginatedGet msg,
    ISigAcceptor<SigSpreadsheetRowsPage> sigAcceptor)
  {
    CallFactory.rpc.create(SigSpreadsheetRowsPage.class, entId, SN, "entRefFieldPaginatedDataGet")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void entReportFieldDataGet(EntId entId, MsgReportFieldDataGet msg,
    ISigAcceptor<SigReportFieldData> sigAcceptor)
  {
    CallFactory.rpc.create(SigReportFieldData.class, entId, SN, "entReportFieldDataGet")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void entSpreadsheetRefFieldDataGet(EntId entId, MsgSpreadsheetRefFieldDataGet msg,
    ISigAcceptor<SigSpreadsheetRefFieldData> sigAcceptor)
  {
    CallFactory.rpc.create(SigSpreadsheetRefFieldData.class, entId, SN,
        "entSpreadsheetRefFieldDataGet")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void entSpreadsheetRowsGet(EntId entId, MsgSpreadsheetRowsGet msg,
    ISigAcceptor<SigSpreadsheetRowsGet> sigAcceptor)
  {
    CallFactory.rpc.create(SigSpreadsheetRowsGet.class, entId, SN, "entSpreadsheetRowsGet")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void entUserPickerCandidateListGet(EntId entId,
    MsgEntUserPickerCandidateListGet msg,
    ISigAcceptor<SigEntUserPickerCandidateListGet> sigAcceptor)
  {
    CallFactory.rpc.create(SigEntUserPickerCandidateListGet.class, entId, SN,
        "entUserPickerCandidateListGet")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void pluginApiOutputGet(EntId entId, MsgPluginApiOutput msg,
    ISigAcceptor<SigPluginApiOutput> sigAcceptor)
  {
    CallFactory.rpc.create(SigPluginApiOutput.class, entId, SN, "pluginApiOutputGet")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }
}
