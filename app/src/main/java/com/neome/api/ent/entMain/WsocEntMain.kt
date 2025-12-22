// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain

import com.neome.api.core.deeplink.sig.SigUrl
import com.neome.api.ent.entMain.msg.MsgAutomationExecutionId
import com.neome.api.ent.entMain.msg.MsgAutomationExecutionIdNoVersion
import com.neome.api.ent.entMain.msg.MsgAutomationStateInfoList
import com.neome.api.ent.entMain.msg.MsgButtonWorkflowExecute
import com.neome.api.ent.entMain.msg.MsgEntVarSeqIncr
import com.neome.api.ent.entMain.msg.MsgFormMappingResultGet
import com.neome.api.ent.entMain.msg.MsgFormResultCalc
import com.neome.api.ent.entMain.msg.MsgPromptActionsGet
import com.neome.api.ent.entMain.msg.MsgPromptTest
import com.neome.api.ent.entMain.msg.MsgReportShare
import com.neome.api.ent.entMain.msg.MsgSpreadsheetBulkRowCommentCountGet
import com.neome.api.ent.entMain.msg.MsgSpreadsheetBulkRowGet
import com.neome.api.ent.entMain.msg.MsgSpreadsheetClear
import com.neome.api.ent.entMain.msg.MsgSpreadsheetEditorShare
import com.neome.api.ent.entMain.msg.MsgSpreadsheetInsertShare
import com.neome.api.ent.entMain.msg.MsgSpreadsheetPartitionSend
import com.neome.api.ent.entMain.msg.MsgSpreadsheetRowCommentCountGet
import com.neome.api.ent.entMain.msg.MsgSpreadsheetRowExpiryGet
import com.neome.api.ent.entMain.msg.MsgSpreadsheetRowGet
import com.neome.api.ent.entMain.msg.MsgSpreadsheetRowMarkRead
import com.neome.api.ent.entMain.msg.MsgSpreadsheetRowRemove
import com.neome.api.ent.entMain.msg.MsgSpreadsheetRowSend
import com.neome.api.ent.entMain.msg.MsgSpreadsheetRowShare
import com.neome.api.ent.entMain.msg.MsgSpreadsheetRowUpdate
import com.neome.api.ent.entMain.msg.MsgWorkflowExecute
import com.neome.api.ent.entMain.msg.MsgWorkflowExecutionIdNoVersion
import com.neome.api.ent.entMain.msg.MsgWorkflowExecutionParamUpdate
import com.neome.api.ent.entMain.msg.MsgWorkflowExecutionResume
import com.neome.api.ent.entMain.sig.SigAutomationState
import com.neome.api.ent.entMain.sig.SigAutomationStateInfoList
import com.neome.api.ent.entMain.sig.SigDebuggerLogsGet
import com.neome.api.ent.entMain.sig.SigEntVarSeq
import com.neome.api.ent.entMain.sig.SigFormMappingResultGet
import com.neome.api.ent.entMain.sig.SigFormValue
import com.neome.api.ent.entMain.sig.SigPromptActions
import com.neome.api.ent.entMain.sig.SigSpreadsheetRowExpiry
import com.neome.api.ent.entMain.sig.SigSpreadsheetRowRemove
import com.neome.api.ent.entMain.sig.SigSpreadsheetRowSend
import com.neome.api.ent.main.sig.SigSpreadsheetBulkRowCommentCount
import com.neome.api.ent.main.sig.SigTaskId
import com.neome.api.home.main.sig.SigSpreadsheetBulkRowGet
import com.neome.api.home.main.sig.SigSpreadsheetRow
import com.neome.api.home.main.sig.SigSpreadsheetRowCommentCount
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.nucleus.base.sig.SigDone

class WsocEntMain {
    companion object {
        val SN: ServiceName = ServiceName.entMain

        fun automationExecutionStatusGet(
            entId: EntId,
            msg: MsgAutomationExecutionId,
            sigAcceptor: ISigAcceptor<SigAutomationState>
        ) {
            CallFactory.wsoc.create(
                SigAutomationState::class.java,
                entId,
                SN,
                "automationExecutionStatusGet"
            )
                .get(msg, sigAcceptor)
        }

        fun buttonWorkflowExecute(
            entId: EntId,
            msg: MsgButtonWorkflowExecute,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.wsoc.create(SigDone::class.java, entId, SN, "buttonWorkflowExecute")
                .post(msg, sigAcceptor)
        }

        fun debuggerLogsGet(entId: EntId, sigAcceptor: ISigAcceptor<SigDebuggerLogsGet>) {
            CallFactory.wsoc.create(SigDebuggerLogsGet::class.java, entId, SN, "debuggerLogsGet")
                .get(null, sigAcceptor)
        }

        fun entAutomationResume(
            entId: EntId,
            msg: MsgAutomationExecutionId,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.wsoc.create(SigDone::class.java, entId, SN, "entAutomationResume")
                .post(msg, sigAcceptor)
        }

        fun entAutomationStateClear(entId: EntId, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.wsoc.create(SigDone::class.java, entId, SN, "entAutomationStateClear")
                .delete(null, sigAcceptor)
        }

        fun entAutomationStateInfoListGet(
            entId: EntId,
            msg: MsgAutomationStateInfoList,
            sigAcceptor: ISigAcceptor<SigAutomationStateInfoList>
        ) {
            CallFactory.wsoc.create(
                SigAutomationStateInfoList::class.java,
                entId,
                SN,
                "entAutomationStateInfoListGet"
            )
                .get(msg, sigAcceptor)
        }

        fun entAutomationStateRemove(
            entId: EntId,
            msg: MsgAutomationExecutionIdNoVersion,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.wsoc.create(SigDone::class.java, entId, SN, "entAutomationStateRemove")
                .delete(msg, sigAcceptor)
        }

        fun entFormMappingResultGet(
            entId: EntId,
            msg: MsgFormMappingResultGet,
            sigAcceptor: ISigAcceptor<SigFormMappingResultGet>
        ) {
            CallFactory.wsoc.create(
                SigFormMappingResultGet::class.java,
                entId,
                SN,
                "entFormMappingResultGet"
            )
                .post(msg, sigAcceptor)
        }

        fun entFormResultCalc(
            entId: EntId,
            msg: MsgFormResultCalc,
            sigAcceptor: ISigAcceptor<SigFormValue>
        ) {
            CallFactory.wsoc.create(SigFormValue::class.java, entId, SN, "entFormResultCalc")
                .post(msg, sigAcceptor)
        }

        fun entPromptActionsGet(
            entId: EntId,
            msg: MsgPromptActionsGet,
            sigAcceptor: ISigAcceptor<SigPromptActions>
        ) {
            CallFactory.wsoc.create(SigPromptActions::class.java, entId, SN, "entPromptActionsGet")
                .post(msg, sigAcceptor)
        }

        fun entPromptExecutorTest(msg: MsgPromptTest, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.wsoc.create(
                SigDone::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "entPromptExecutorTest"
            )
                .post(msg, sigAcceptor)
        }

        fun entReportShare(entId: EntId, msg: MsgReportShare, sigAcceptor: ISigAcceptor<SigUrl>) {
            CallFactory.wsoc.create(SigUrl::class.java, entId, SN, "entReportShare")
                .put(msg, sigAcceptor)
        }

        fun entSpreadsheetEditorShare(
            entId: EntId,
            msg: MsgSpreadsheetEditorShare,
            sigAcceptor: ISigAcceptor<SigUrl>
        ) {
            CallFactory.wsoc.create(SigUrl::class.java, entId, SN, "entSpreadsheetEditorShare")
                .get(msg, sigAcceptor)
        }

        fun entSpreadsheetInsertShare(
            entId: EntId,
            msg: MsgSpreadsheetInsertShare,
            sigAcceptor: ISigAcceptor<SigUrl>
        ) {
            CallFactory.wsoc.create(SigUrl::class.java, entId, SN, "entSpreadsheetInsertShare")
                .post(msg, sigAcceptor)
        }

        fun entSpreadsheetRowShare(
            entId: EntId,
            msg: MsgSpreadsheetRowShare,
            sigAcceptor: ISigAcceptor<SigUrl>
        ) {
            CallFactory.wsoc.create(SigUrl::class.java, entId, SN, "entSpreadsheetRowShare")
                .get(msg, sigAcceptor)
        }

        fun entVarSeqIncr(
            entId: EntId,
            msg: MsgEntVarSeqIncr,
            sigAcceptor: ISigAcceptor<SigEntVarSeq>
        ) {
            CallFactory.wsoc.create(SigEntVarSeq::class.java, entId, SN, "entVarSeqIncr")
                .get(msg, sigAcceptor)
        }

        fun spreadsheetBulkRowCommentCountGet(
            entId: EntId,
            msg: MsgSpreadsheetBulkRowCommentCountGet,
            sigAcceptor: ISigAcceptor<SigSpreadsheetBulkRowCommentCount>
        ) {
            CallFactory.wsoc.create(
                SigSpreadsheetBulkRowCommentCount::class.java,
                entId,
                SN,
                "spreadsheetBulkRowCommentCountGet"
            )
                .post(msg, sigAcceptor)
        }

        fun spreadsheetBulkRowGet(
            entId: EntId,
            msg: MsgSpreadsheetBulkRowGet,
            sigAcceptor: ISigAcceptor<SigSpreadsheetBulkRowGet>
        ) {
            CallFactory.wsoc.create(
                SigSpreadsheetBulkRowGet::class.java,
                entId,
                SN,
                "spreadsheetBulkRowGet"
            )
                .post(msg, sigAcceptor)
        }

        fun spreadsheetBulkRowRemove(
            entId: EntId,
            msg: MsgSpreadsheetRowRemove,
            sigAcceptor: ISigAcceptor<SigTaskId>
        ) {
            CallFactory.wsoc.create(SigTaskId::class.java, entId, SN, "spreadsheetBulkRowRemove")
                .delete(msg, sigAcceptor)
        }

        fun spreadsheetClear(
            entId: EntId,
            msg: MsgSpreadsheetClear,
            sigAcceptor: ISigAcceptor<SigTaskId>
        ) {
            CallFactory.wsoc.create(SigTaskId::class.java, entId, SN, "spreadsheetClear")
                .delete(msg, sigAcceptor)
        }

        fun spreadsheetPartitionSend(
            entId: EntId,
            msg: MsgSpreadsheetPartitionSend,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.wsoc.create(SigDone::class.java, entId, SN, "spreadsheetPartitionSend")
                .post(msg, sigAcceptor)
        }

        fun spreadsheetRowCommentCountGet(
            entId: EntId,
            msg: MsgSpreadsheetRowCommentCountGet,
            sigAcceptor: ISigAcceptor<SigSpreadsheetRowCommentCount>
        ) {
            CallFactory.wsoc.create(
                SigSpreadsheetRowCommentCount::class.java,
                entId,
                SN,
                "spreadsheetRowCommentCountGet"
            )
                .get(msg, sigAcceptor)
        }

        fun spreadsheetRowExpiryGet(
            entId: EntId,
            msg: MsgSpreadsheetRowExpiryGet,
            sigAcceptor: ISigAcceptor<SigSpreadsheetRowExpiry>
        ) {
            CallFactory.wsoc.create(
                SigSpreadsheetRowExpiry::class.java,
                entId,
                SN,
                "spreadsheetRowExpiryGet"
            )
                .get(msg, sigAcceptor)
        }

        fun spreadsheetRowGet(
            entId: EntId,
            msg: MsgSpreadsheetRowGet,
            sigAcceptor: ISigAcceptor<SigSpreadsheetRow>
        ) {
            CallFactory.wsoc.create(SigSpreadsheetRow::class.java, entId, SN, "spreadsheetRowGet")
                .get(msg, sigAcceptor)
        }

        fun spreadsheetRowMarkRead(
            entId: EntId,
            msg: MsgSpreadsheetRowMarkRead,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.wsoc.create(SigDone::class.java, entId, SN, "spreadsheetRowMarkRead")
                .put(msg, sigAcceptor)
        }

        fun spreadsheetRowRemove(
            entId: EntId,
            msg: MsgSpreadsheetRowRemove,
            sigAcceptor: ISigAcceptor<SigSpreadsheetRowRemove>
        ) {
            CallFactory.wsoc.create(
                SigSpreadsheetRowRemove::class.java,
                entId,
                SN,
                "spreadsheetRowRemove"
            )
                .delete(msg, sigAcceptor)
        }

        fun spreadsheetRowSend(
            entId: EntId,
            msg: MsgSpreadsheetRowSend,
            sigAcceptor: ISigAcceptor<SigSpreadsheetRowSend>
        ) {
            CallFactory.wsoc.create(
                SigSpreadsheetRowSend::class.java,
                entId,
                SN,
                "spreadsheetRowSend"
            )
                .post(msg, sigAcceptor)
        }

        fun spreadsheetRowUpdate(
            entId: EntId,
            msg: MsgSpreadsheetRowUpdate,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.wsoc.create(SigDone::class.java, entId, SN, "spreadsheetRowUpdate")
                .post(msg, sigAcceptor)
        }

        fun workflowExecute(
            entId: EntId,
            msg: MsgWorkflowExecute,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.wsoc.create(SigDone::class.java, entId, SN, "workflowExecute")
                .post(msg, sigAcceptor)
        }

        fun workflowExecutionParamUpdate(
            entId: EntId,
            msg: MsgWorkflowExecutionParamUpdate,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.wsoc.create(SigDone::class.java, entId, SN, "workflowExecutionParamUpdate")
                .post(msg, sigAcceptor)
        }

        fun workflowExecutionResume(
            entId: EntId,
            msg: MsgWorkflowExecutionResume,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.wsoc.create(SigDone::class.java, entId, SN, "workflowExecutionResume")
                .post(msg, sigAcceptor)
        }

        fun workflowExecutionStateClear(entId: EntId, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.wsoc.create(SigDone::class.java, entId, SN, "workflowExecutionStateClear")
                .delete(null, sigAcceptor)
        }

        fun workflowExecutionStateRemove(
            entId: EntId,
            msg: MsgWorkflowExecutionIdNoVersion,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.wsoc.create(SigDone::class.java, entId, SN, "workflowExecutionStateRemove")
                .delete(msg, sigAcceptor)
        }
    }
}
