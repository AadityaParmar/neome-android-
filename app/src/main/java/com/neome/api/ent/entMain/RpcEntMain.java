// neome.ai API - do not change
//
/* eslint-disable @typescript-eslint/no-unused-vars */
// noinspection UnusedGlobalSymbols,ES6UnusedImports,JSUnusedGlobalSymbols,JSUnusedLocalSymbols

package com.neome.api.ent.entMain;

import com.neome.api.core.base.msg.MsgVersion;
import com.neome.api.core.deeplink.sig.SigUrl;
import com.neome.api.ent.ent.sig.SigReportOutputFormGet;
import com.neome.api.ent.entMain.msg.MsgAutomationExecutionId;
import com.neome.api.ent.entMain.msg.MsgAutomationExecutionIdNoVersion;
import com.neome.api.ent.entMain.msg.MsgAutomationStateInfoList;
import com.neome.api.ent.entMain.msg.MsgButtonWorkflowExecute;
import com.neome.api.ent.entMain.msg.MsgEntExportExcel;
import com.neome.api.ent.entMain.msg.MsgEntFormExport;
import com.neome.api.ent.entMain.msg.MsgEntJoin;
import com.neome.api.ent.entMain.msg.MsgEntVarSeqIncr;
import com.neome.api.ent.entMain.msg.MsgFormMappingResultGet;
import com.neome.api.ent.entMain.msg.MsgFormResultCalc;
import com.neome.api.ent.entMain.msg.MsgLocationLogPut;
import com.neome.api.ent.entMain.msg.MsgPdfMerge;
import com.neome.api.ent.entMain.msg.MsgPromptActionsGet;
import com.neome.api.ent.entMain.msg.MsgPromptTest;
import com.neome.api.ent.entMain.msg.MsgReportOutputFormGet;
import com.neome.api.ent.entMain.msg.MsgReportShare;
import com.neome.api.ent.entMain.msg.MsgSpreadsheetBulkRowCommentCountGet;
import com.neome.api.ent.entMain.msg.MsgSpreadsheetBulkRowGet;
import com.neome.api.ent.entMain.msg.MsgSpreadsheetClear;
import com.neome.api.ent.entMain.msg.MsgSpreadsheetEditorShare;
import com.neome.api.ent.entMain.msg.MsgSpreadsheetHistoryFormValue;
import com.neome.api.ent.entMain.msg.MsgSpreadsheetHistoryGet;
import com.neome.api.ent.entMain.msg.MsgSpreadsheetInsertShare;
import com.neome.api.ent.entMain.msg.MsgSpreadsheetPartitionSend;
import com.neome.api.ent.entMain.msg.MsgSpreadsheetRowCommentCountGet;
import com.neome.api.ent.entMain.msg.MsgSpreadsheetRowExpiryGet;
import com.neome.api.ent.entMain.msg.MsgSpreadsheetRowGet;
import com.neome.api.ent.entMain.msg.MsgSpreadsheetRowMarkRead;
import com.neome.api.ent.entMain.msg.MsgSpreadsheetRowRemove;
import com.neome.api.ent.entMain.msg.MsgSpreadsheetRowSend;
import com.neome.api.ent.entMain.msg.MsgSpreadsheetRowShare;
import com.neome.api.ent.entMain.msg.MsgSpreadsheetRowUpdate;
import com.neome.api.ent.entMain.msg.MsgSpreadsheetRowsPageGet;
import com.neome.api.ent.entMain.msg.MsgUserActionExecute;
import com.neome.api.ent.entMain.msg.MsgWorkflowExecute;
import com.neome.api.ent.entMain.msg.MsgWorkflowExecutionId;
import com.neome.api.ent.entMain.msg.MsgWorkflowExecutionIdNoVersion;
import com.neome.api.ent.entMain.msg.MsgWorkflowExecutionParamUpdate;
import com.neome.api.ent.entMain.msg.MsgWorkflowExecutionResume;
import com.neome.api.ent.entMain.msg.MsgWorkflowExecutionStateList;
import com.neome.api.ent.entMain.sig.SigAuditRecordList;
import com.neome.api.ent.entMain.sig.SigAutomationState;
import com.neome.api.ent.entMain.sig.SigAutomationStateInfoList;
import com.neome.api.ent.entMain.sig.SigDebuggerLogsGet;
import com.neome.api.ent.entMain.sig.SigEntFormExport;
import com.neome.api.ent.entMain.sig.SigEntInvitationList;
import com.neome.api.ent.entMain.sig.SigEntUserAvatarListGet;
import com.neome.api.ent.entMain.sig.SigEntVarSeq;
import com.neome.api.ent.entMain.sig.SigFormMappingResultGet;
import com.neome.api.ent.entMain.sig.SigFormValue;
import com.neome.api.ent.entMain.sig.SigPdfMerge;
import com.neome.api.ent.entMain.sig.SigPromptActions;
import com.neome.api.ent.entMain.sig.SigSpreadsheetHistoryFormValue;
import com.neome.api.ent.entMain.sig.SigSpreadsheetRowExpiry;
import com.neome.api.ent.entMain.sig.SigSpreadsheetRowRemove;
import com.neome.api.ent.entMain.sig.SigSpreadsheetRowSend;
import com.neome.api.ent.entMain.sig.SigSpreadsheetRowsPage;
import com.neome.api.ent.entMain.sig.SigUserActionResult;
import com.neome.api.ent.entMain.sig.SigWorkflowExecutionState;
import com.neome.api.ent.entMain.sig.SigWorkflowExecutionStateList;
import com.neome.api.ent.main.msg.MsgSpreadsheetBulkRowInsert;
import com.neome.api.ent.main.msg.MsgSpreadsheetBulkRowUpdate;
import com.neome.api.ent.main.sig.SigSpreadsheetBulkRowCommentCount;
import com.neome.api.ent.main.sig.SigSpreadsheetBulkRowInsert;
import com.neome.api.ent.main.sig.SigTaskId;
import com.neome.api.home.main.sig.SigSpreadsheetBulkRowGet;
import com.neome.api.home.main.sig.SigSpreadsheetRow;
import com.neome.api.home.main.sig.SigSpreadsheetRowCommentCount;
import com.neome.api.meta.base.Types.EntId;
import com.neome.api.meta.base.Types.ServiceName;
import com.neome.api.nucleus.base.ApiPlus;
import com.neome.api.nucleus.base.CallFactory;
import com.neome.api.nucleus.base.ISigAcceptor;
import com.neome.api.nucleus.base.sig.SigDone;

@SuppressWarnings("unused")
public class RpcEntMain
{
  public static final ServiceName SN = ServiceName.entMain;

  public static void automationExecutionStatusGet(EntId entId, MsgAutomationExecutionId msg,
    ISigAcceptor<SigAutomationState> sigAcceptor)
  {
    CallFactory.rpc.create(SigAutomationState.class, entId, SN, "automationExecutionStatusGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void buttonWorkflowExecute(EntId entId, MsgButtonWorkflowExecute msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, entId, SN, "buttonWorkflowExecute")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void debuggerLogsGet(EntId entId, ISigAcceptor<SigDebuggerLogsGet> sigAcceptor)
  {
    CallFactory.rpc.create(SigDebuggerLogsGet.class, entId, SN, "debuggerLogsGet")
      .sendBearerToken()
      .get(null, sigAcceptor);
  }

  public static void entAutomationResume(EntId entId, MsgAutomationExecutionId msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, entId, SN, "entAutomationResume")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void entAutomationStateClear(EntId entId, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, entId, SN, "entAutomationStateClear")
      .sendBearerToken()
      .delete(null, sigAcceptor);
  }

  public static void entAutomationStateInfoListGet(EntId entId, MsgAutomationStateInfoList msg,
    ISigAcceptor<SigAutomationStateInfoList> sigAcceptor)
  {
    CallFactory.rpc.create(SigAutomationStateInfoList.class, entId, SN,
        "entAutomationStateInfoListGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void entAutomationStateRemove(EntId entId, MsgAutomationExecutionIdNoVersion msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, entId, SN, "entAutomationStateRemove")
      .sendBearerToken()
      .delete(msg, sigAcceptor);
  }

  public static void entExportExcel(MsgEntExportExcel msg, ISigAcceptor<SigTaskId> sigAcceptor)
  {
    CallFactory.rpc.create(SigTaskId.class, ApiPlus.ENT_ID_GLOBAL, SN, "entExportExcel")
      .sendRefreshToken()
      .post(msg, sigAcceptor);
  }

  public static void entFormExport(MsgEntFormExport msg, ISigAcceptor<SigEntFormExport> sigAcceptor)
  {
    CallFactory.rpc.create(SigEntFormExport.class, ApiPlus.ENT_ID_GLOBAL, SN, "entFormExport")
      .sendRefreshToken()
      .post(msg, sigAcceptor);
  }

  public static void entFormMappingResultGet(EntId entId, MsgFormMappingResultGet msg,
    ISigAcceptor<SigFormMappingResultGet> sigAcceptor)
  {
    CallFactory.rpc.create(SigFormMappingResultGet.class, entId, SN, "entFormMappingResultGet")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void entFormResultCalc(EntId entId, MsgFormResultCalc msg,
    ISigAcceptor<SigFormValue> sigAcceptor)
  {
    CallFactory.rpc.create(SigFormValue.class, entId, SN, "entFormResultCalc")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void entInvitationListGet(ISigAcceptor<SigEntInvitationList> sigAcceptor)
  {
    CallFactory.rpc.create(SigEntInvitationList.class, ApiPlus.ENT_ID_GLOBAL, SN,
        "entInvitationListGet")
      .sendBearerToken()
      .get(null, sigAcceptor);
  }

  public static void entJoin(MsgEntJoin msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "entJoin")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void entPromptActionsGet(EntId entId, MsgPromptActionsGet msg,
    ISigAcceptor<SigPromptActions> sigAcceptor)
  {
    CallFactory.rpc.create(SigPromptActions.class, entId, SN, "entPromptActionsGet")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void entPromptExecutorTest(MsgPromptTest msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "entPromptExecutorTest")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void entReportOutputFormGet(EntId entId, MsgReportOutputFormGet msg,
    ISigAcceptor<SigReportOutputFormGet> sigAcceptor)
  {
    CallFactory.rpc.create(SigReportOutputFormGet.class, entId, SN, "entReportOutputFormGet")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void entReportShare(EntId entId, MsgReportShare msg,
    ISigAcceptor<SigUrl> sigAcceptor)
  {
    CallFactory.rpc.create(SigUrl.class, entId, SN, "entReportShare")
      .sendBearerToken()
      .put(msg, sigAcceptor);
  }

  public static void entSpreadsheetEditorShare(EntId entId, MsgSpreadsheetEditorShare msg,
    ISigAcceptor<SigUrl> sigAcceptor)
  {
    CallFactory.rpc.create(SigUrl.class, entId, SN, "entSpreadsheetEditorShare")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void entSpreadsheetInsertShare(EntId entId, MsgSpreadsheetInsertShare msg,
    ISigAcceptor<SigUrl> sigAcceptor)
  {
    CallFactory.rpc.create(SigUrl.class, entId, SN, "entSpreadsheetInsertShare")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void entSpreadsheetRowShare(EntId entId, MsgSpreadsheetRowShare msg,
    ISigAcceptor<SigUrl> sigAcceptor)
  {
    CallFactory.rpc.create(SigUrl.class, entId, SN, "entSpreadsheetRowShare")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void entUserAvatarListGet(EntId entId, MsgVersion msg,
    ISigAcceptor<SigEntUserAvatarListGet> sigAcceptor)
  {
    CallFactory.rpc.create(SigEntUserAvatarListGet.class, entId, SN, "entUserAvatarListGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void entVarSeqIncr(EntId entId, MsgEntVarSeqIncr msg,
    ISigAcceptor<SigEntVarSeq> sigAcceptor)
  {
    CallFactory.rpc.create(SigEntVarSeq.class, entId, SN, "entVarSeqIncr")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void locationLogPut(MsgLocationLogPut msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "locationLogPut")
      .sendRefreshToken()
      .put(msg, sigAcceptor);
  }

  public static void pdfMerge(EntId entId, MsgPdfMerge msg, ISigAcceptor<SigPdfMerge> sigAcceptor)
  {
    CallFactory.rpc.create(SigPdfMerge.class, entId, SN, "pdfMerge")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void spreadsheetBulkRowCommentCountGet(EntId entId,
    MsgSpreadsheetBulkRowCommentCountGet msg,
    ISigAcceptor<SigSpreadsheetBulkRowCommentCount> sigAcceptor)
  {
    CallFactory.rpc.create(SigSpreadsheetBulkRowCommentCount.class, entId, SN,
        "spreadsheetBulkRowCommentCountGet")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void spreadsheetBulkRowGet(EntId entId, MsgSpreadsheetBulkRowGet msg,
    ISigAcceptor<SigSpreadsheetBulkRowGet> sigAcceptor)
  {
    CallFactory.rpc.create(SigSpreadsheetBulkRowGet.class, entId, SN, "spreadsheetBulkRowGet")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void spreadsheetBulkRowInsert(EntId entId, MsgSpreadsheetBulkRowInsert msg,
    ISigAcceptor<SigSpreadsheetBulkRowInsert> sigAcceptor)
  {
    CallFactory.rpc.create(SigSpreadsheetBulkRowInsert.class, entId, SN, "spreadsheetBulkRowInsert")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void spreadsheetBulkRowRemove(EntId entId, MsgSpreadsheetRowRemove msg,
    ISigAcceptor<SigTaskId> sigAcceptor)
  {
    CallFactory.rpc.create(SigTaskId.class, entId, SN, "spreadsheetBulkRowRemove")
      .sendBearerToken()
      .delete(msg, sigAcceptor);
  }

  public static void spreadsheetBulkRowUpdate(EntId entId, MsgSpreadsheetBulkRowUpdate msg,
    ISigAcceptor<SigTaskId> sigAcceptor)
  {
    CallFactory.rpc.create(SigTaskId.class, entId, SN, "spreadsheetBulkRowUpdate")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void spreadsheetClear(EntId entId, MsgSpreadsheetClear msg,
    ISigAcceptor<SigTaskId> sigAcceptor)
  {
    CallFactory.rpc.create(SigTaskId.class, entId, SN, "spreadsheetClear")
      .sendBearerToken()
      .delete(msg, sigAcceptor);
  }

  public static void spreadsheetHistoryFormValueGet(EntId entId, MsgSpreadsheetHistoryFormValue msg,
    ISigAcceptor<SigSpreadsheetHistoryFormValue> sigAcceptor)
  {
    CallFactory.rpc.create(SigSpreadsheetHistoryFormValue.class, entId, SN,
        "spreadsheetHistoryFormValueGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void spreadsheetHistoryGet(EntId entId, MsgSpreadsheetHistoryGet msg,
    ISigAcceptor<SigAuditRecordList> sigAcceptor)
  {
    CallFactory.rpc.create(SigAuditRecordList.class, entId, SN, "spreadsheetHistoryGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void spreadsheetPartitionSend(EntId entId, MsgSpreadsheetPartitionSend msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, entId, SN, "spreadsheetPartitionSend")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void spreadsheetRowCommentCountGet(EntId entId,
    MsgSpreadsheetRowCommentCountGet msg, ISigAcceptor<SigSpreadsheetRowCommentCount> sigAcceptor)
  {
    CallFactory.rpc.create(SigSpreadsheetRowCommentCount.class, entId, SN,
        "spreadsheetRowCommentCountGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void spreadsheetRowExpiryGet(EntId entId, MsgSpreadsheetRowExpiryGet msg,
    ISigAcceptor<SigSpreadsheetRowExpiry> sigAcceptor)
  {
    CallFactory.rpc.create(SigSpreadsheetRowExpiry.class, entId, SN, "spreadsheetRowExpiryGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void spreadsheetRowGet(EntId entId, MsgSpreadsheetRowGet msg,
    ISigAcceptor<SigSpreadsheetRow> sigAcceptor)
  {
    CallFactory.rpc.create(SigSpreadsheetRow.class, entId, SN, "spreadsheetRowGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void spreadsheetRowMarkRead(EntId entId, MsgSpreadsheetRowMarkRead msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, entId, SN, "spreadsheetRowMarkRead")
      .sendBearerToken()
      .put(msg, sigAcceptor);
  }

  public static void spreadsheetRowRemove(EntId entId, MsgSpreadsheetRowRemove msg,
    ISigAcceptor<SigSpreadsheetRowRemove> sigAcceptor)
  {
    CallFactory.rpc.create(SigSpreadsheetRowRemove.class, entId, SN, "spreadsheetRowRemove")
      .sendBearerToken()
      .delete(msg, sigAcceptor);
  }

  public static void spreadsheetRowSend(EntId entId, MsgSpreadsheetRowSend msg,
    ISigAcceptor<SigSpreadsheetRowSend> sigAcceptor)
  {
    CallFactory.rpc.create(SigSpreadsheetRowSend.class, entId, SN, "spreadsheetRowSend")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void spreadsheetRowUpdate(EntId entId, MsgSpreadsheetRowUpdate msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, entId, SN, "spreadsheetRowUpdate")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void spreadsheetRowsPageGet(EntId entId, MsgSpreadsheetRowsPageGet msg,
    ISigAcceptor<SigSpreadsheetRowsPage> sigAcceptor)
  {
    CallFactory.rpc.create(SigSpreadsheetRowsPage.class, entId, SN, "spreadsheetRowsPageGet")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void userActionExecute(EntId entId, MsgUserActionExecute msg,
    ISigAcceptor<SigUserActionResult> sigAcceptor)
  {
    CallFactory.rpc.create(SigUserActionResult.class, entId, SN, "userActionExecute")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void workflowExecute(EntId entId, MsgWorkflowExecute msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, entId, SN, "workflowExecute")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void workflowExecutionParamUpdate(EntId entId, MsgWorkflowExecutionParamUpdate msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, entId, SN, "workflowExecutionParamUpdate")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void workflowExecutionResume(EntId entId, MsgWorkflowExecutionResume msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, entId, SN, "workflowExecutionResume")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void workflowExecutionStateClear(EntId entId, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, entId, SN, "workflowExecutionStateClear")
      .sendBearerToken()
      .delete(null, sigAcceptor);
  }

  public static void workflowExecutionStateGet(EntId entId, MsgWorkflowExecutionId msg,
    ISigAcceptor<SigWorkflowExecutionState> sigAcceptor)
  {
    CallFactory.rpc.create(SigWorkflowExecutionState.class, entId, SN, "workflowExecutionStateGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void workflowExecutionStateListGet(EntId entId, MsgWorkflowExecutionStateList msg,
    ISigAcceptor<SigWorkflowExecutionStateList> sigAcceptor)
  {
    CallFactory.rpc.create(SigWorkflowExecutionStateList.class, entId, SN,
        "workflowExecutionStateListGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void workflowExecutionStateRemove(EntId entId, MsgWorkflowExecutionIdNoVersion msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, entId, SN, "workflowExecutionStateRemove")
      .sendBearerToken()
      .delete(msg, sigAcceptor);
  }
}
