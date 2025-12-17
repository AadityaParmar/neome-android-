// neome.ai API - do not change
//
/* eslint-disable @typescript-eslint/no-unused-vars */
// noinspection UnusedGlobalSymbols,ES6UnusedImports,JSUnusedGlobalSymbols,JSUnusedLocalSymbols

package com.neome.api.ent.entMain;

import com.neome.api.core.deeplink.sig.SigUrl;
import com.neome.api.ent.entMain.msg.MsgAutomationExecutionId;
import com.neome.api.ent.entMain.msg.MsgAutomationExecutionIdNoVersion;
import com.neome.api.ent.entMain.msg.MsgAutomationStateInfoList;
import com.neome.api.ent.entMain.msg.MsgButtonWorkflowExecute;
import com.neome.api.ent.entMain.msg.MsgEntVarSeqIncr;
import com.neome.api.ent.entMain.msg.MsgFormMappingResultGet;
import com.neome.api.ent.entMain.msg.MsgFormResultCalc;
import com.neome.api.ent.entMain.msg.MsgPromptActionsGet;
import com.neome.api.ent.entMain.msg.MsgPromptTest;
import com.neome.api.ent.entMain.msg.MsgReportShare;
import com.neome.api.ent.entMain.msg.MsgSpreadsheetBulkRowCommentCountGet;
import com.neome.api.ent.entMain.msg.MsgSpreadsheetBulkRowGet;
import com.neome.api.ent.entMain.msg.MsgSpreadsheetClear;
import com.neome.api.ent.entMain.msg.MsgSpreadsheetEditorShare;
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
import com.neome.api.ent.entMain.msg.MsgWorkflowExecute;
import com.neome.api.ent.entMain.msg.MsgWorkflowExecutionIdNoVersion;
import com.neome.api.ent.entMain.msg.MsgWorkflowExecutionParamUpdate;
import com.neome.api.ent.entMain.msg.MsgWorkflowExecutionResume;
import com.neome.api.ent.entMain.sig.SigAutomationState;
import com.neome.api.ent.entMain.sig.SigAutomationStateInfoList;
import com.neome.api.ent.entMain.sig.SigDebuggerLogsGet;
import com.neome.api.ent.entMain.sig.SigEntVarSeq;
import com.neome.api.ent.entMain.sig.SigFormMappingResultGet;
import com.neome.api.ent.entMain.sig.SigFormValue;
import com.neome.api.ent.entMain.sig.SigPromptActions;
import com.neome.api.ent.entMain.sig.SigSpreadsheetRowExpiry;
import com.neome.api.ent.entMain.sig.SigSpreadsheetRowRemove;
import com.neome.api.ent.entMain.sig.SigSpreadsheetRowSend;
import com.neome.api.ent.main.sig.SigSpreadsheetBulkRowCommentCount;
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
public class WsocEntMain
{
  public static final ServiceName SN = ServiceName.entMain;

  public static void automationExecutionStatusGet(EntId entId, MsgAutomationExecutionId msg,
    ISigAcceptor<SigAutomationState> sigAcceptor)
  {
    CallFactory.wsoc.create(SigAutomationState.class, entId, SN, "automationExecutionStatusGet")
      .get(msg, sigAcceptor);
  }

  public static void buttonWorkflowExecute(EntId entId, MsgButtonWorkflowExecute msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, entId, SN, "buttonWorkflowExecute")
      .post(msg, sigAcceptor);
  }

  public static void debuggerLogsGet(EntId entId, ISigAcceptor<SigDebuggerLogsGet> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDebuggerLogsGet.class, entId, SN, "debuggerLogsGet")
      .get(null, sigAcceptor);
  }

  public static void entAutomationResume(EntId entId, MsgAutomationExecutionId msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, entId, SN, "entAutomationResume")
      .post(msg, sigAcceptor);
  }

  public static void entAutomationStateClear(EntId entId, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, entId, SN, "entAutomationStateClear")
      .delete(null, sigAcceptor);
  }

  public static void entAutomationStateInfoListGet(EntId entId, MsgAutomationStateInfoList msg,
    ISigAcceptor<SigAutomationStateInfoList> sigAcceptor)
  {
    CallFactory.wsoc.create(SigAutomationStateInfoList.class, entId, SN,
        "entAutomationStateInfoListGet")
      .get(msg, sigAcceptor);
  }

  public static void entAutomationStateRemove(EntId entId, MsgAutomationExecutionIdNoVersion msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, entId, SN, "entAutomationStateRemove")
      .delete(msg, sigAcceptor);
  }

  public static void entFormMappingResultGet(EntId entId, MsgFormMappingResultGet msg,
    ISigAcceptor<SigFormMappingResultGet> sigAcceptor)
  {
    CallFactory.wsoc.create(SigFormMappingResultGet.class, entId, SN, "entFormMappingResultGet")
      .post(msg, sigAcceptor);
  }

  public static void entFormResultCalc(EntId entId, MsgFormResultCalc msg,
    ISigAcceptor<SigFormValue> sigAcceptor)
  {
    CallFactory.wsoc.create(SigFormValue.class, entId, SN, "entFormResultCalc")
      .post(msg, sigAcceptor);
  }

  public static void entPromptActionsGet(EntId entId, MsgPromptActionsGet msg,
    ISigAcceptor<SigPromptActions> sigAcceptor)
  {
    CallFactory.wsoc.create(SigPromptActions.class, entId, SN, "entPromptActionsGet")
      .post(msg, sigAcceptor);
  }

  public static void entPromptExecutorTest(MsgPromptTest msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "entPromptExecutorTest")
      .post(msg, sigAcceptor);
  }

  public static void entReportShare(EntId entId, MsgReportShare msg,
    ISigAcceptor<SigUrl> sigAcceptor)
  {
    CallFactory.wsoc.create(SigUrl.class, entId, SN, "entReportShare")
      .put(msg, sigAcceptor);
  }

  public static void entSpreadsheetEditorShare(EntId entId, MsgSpreadsheetEditorShare msg,
    ISigAcceptor<SigUrl> sigAcceptor)
  {
    CallFactory.wsoc.create(SigUrl.class, entId, SN, "entSpreadsheetEditorShare")
      .get(msg, sigAcceptor);
  }

  public static void entSpreadsheetInsertShare(EntId entId, MsgSpreadsheetInsertShare msg,
    ISigAcceptor<SigUrl> sigAcceptor)
  {
    CallFactory.wsoc.create(SigUrl.class, entId, SN, "entSpreadsheetInsertShare")
      .post(msg, sigAcceptor);
  }

  public static void entSpreadsheetRowShare(EntId entId, MsgSpreadsheetRowShare msg,
    ISigAcceptor<SigUrl> sigAcceptor)
  {
    CallFactory.wsoc.create(SigUrl.class, entId, SN, "entSpreadsheetRowShare")
      .get(msg, sigAcceptor);
  }

  public static void entVarSeqIncr(EntId entId, MsgEntVarSeqIncr msg,
    ISigAcceptor<SigEntVarSeq> sigAcceptor)
  {
    CallFactory.wsoc.create(SigEntVarSeq.class, entId, SN, "entVarSeqIncr")
      .get(msg, sigAcceptor);
  }

  public static void spreadsheetBulkRowCommentCountGet(EntId entId,
    MsgSpreadsheetBulkRowCommentCountGet msg,
    ISigAcceptor<SigSpreadsheetBulkRowCommentCount> sigAcceptor)
  {
    CallFactory.wsoc.create(SigSpreadsheetBulkRowCommentCount.class, entId, SN,
        "spreadsheetBulkRowCommentCountGet")
      .post(msg, sigAcceptor);
  }

  public static void spreadsheetBulkRowGet(EntId entId, MsgSpreadsheetBulkRowGet msg,
    ISigAcceptor<SigSpreadsheetBulkRowGet> sigAcceptor)
  {
    CallFactory.wsoc.create(SigSpreadsheetBulkRowGet.class, entId, SN, "spreadsheetBulkRowGet")
      .post(msg, sigAcceptor);
  }

  public static void spreadsheetBulkRowRemove(EntId entId, MsgSpreadsheetRowRemove msg,
    ISigAcceptor<SigTaskId> sigAcceptor)
  {
    CallFactory.wsoc.create(SigTaskId.class, entId, SN, "spreadsheetBulkRowRemove")
      .delete(msg, sigAcceptor);
  }

  public static void spreadsheetClear(EntId entId, MsgSpreadsheetClear msg,
    ISigAcceptor<SigTaskId> sigAcceptor)
  {
    CallFactory.wsoc.create(SigTaskId.class, entId, SN, "spreadsheetClear")
      .delete(msg, sigAcceptor);
  }

  public static void spreadsheetPartitionSend(EntId entId, MsgSpreadsheetPartitionSend msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, entId, SN, "spreadsheetPartitionSend")
      .post(msg, sigAcceptor);
  }

  public static void spreadsheetRowCommentCountGet(EntId entId,
    MsgSpreadsheetRowCommentCountGet msg, ISigAcceptor<SigSpreadsheetRowCommentCount> sigAcceptor)
  {
    CallFactory.wsoc.create(SigSpreadsheetRowCommentCount.class, entId, SN,
        "spreadsheetRowCommentCountGet")
      .get(msg, sigAcceptor);
  }

  public static void spreadsheetRowExpiryGet(EntId entId, MsgSpreadsheetRowExpiryGet msg,
    ISigAcceptor<SigSpreadsheetRowExpiry> sigAcceptor)
  {
    CallFactory.wsoc.create(SigSpreadsheetRowExpiry.class, entId, SN, "spreadsheetRowExpiryGet")
      .get(msg, sigAcceptor);
  }

  public static void spreadsheetRowGet(EntId entId, MsgSpreadsheetRowGet msg,
    ISigAcceptor<SigSpreadsheetRow> sigAcceptor)
  {
    CallFactory.wsoc.create(SigSpreadsheetRow.class, entId, SN, "spreadsheetRowGet")
      .get(msg, sigAcceptor);
  }

  public static void spreadsheetRowMarkRead(EntId entId, MsgSpreadsheetRowMarkRead msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, entId, SN, "spreadsheetRowMarkRead")
      .put(msg, sigAcceptor);
  }

  public static void spreadsheetRowRemove(EntId entId, MsgSpreadsheetRowRemove msg,
    ISigAcceptor<SigSpreadsheetRowRemove> sigAcceptor)
  {
    CallFactory.wsoc.create(SigSpreadsheetRowRemove.class, entId, SN, "spreadsheetRowRemove")
      .delete(msg, sigAcceptor);
  }

  public static void spreadsheetRowSend(EntId entId, MsgSpreadsheetRowSend msg,
    ISigAcceptor<SigSpreadsheetRowSend> sigAcceptor)
  {
    CallFactory.wsoc.create(SigSpreadsheetRowSend.class, entId, SN, "spreadsheetRowSend")
      .post(msg, sigAcceptor);
  }

  public static void spreadsheetRowUpdate(EntId entId, MsgSpreadsheetRowUpdate msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, entId, SN, "spreadsheetRowUpdate")
      .post(msg, sigAcceptor);
  }

  public static void workflowExecute(EntId entId, MsgWorkflowExecute msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, entId, SN, "workflowExecute")
      .post(msg, sigAcceptor);
  }

  public static void workflowExecutionParamUpdate(EntId entId, MsgWorkflowExecutionParamUpdate msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, entId, SN, "workflowExecutionParamUpdate")
      .post(msg, sigAcceptor);
  }

  public static void workflowExecutionResume(EntId entId, MsgWorkflowExecutionResume msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, entId, SN, "workflowExecutionResume")
      .post(msg, sigAcceptor);
  }

  public static void workflowExecutionStateClear(EntId entId, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, entId, SN, "workflowExecutionStateClear")
      .delete(null, sigAcceptor);
  }

  public static void workflowExecutionStateRemove(EntId entId, MsgWorkflowExecutionIdNoVersion msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, entId, SN, "workflowExecutionStateRemove")
      .delete(msg, sigAcceptor);
  }
}
