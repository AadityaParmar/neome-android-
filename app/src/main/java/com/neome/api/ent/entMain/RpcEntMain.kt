// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain

import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.ent.entMain.msg.MsgAutomationExecutionId
import com.neome.api.ent.entMain.msg.MsgAutomationExecutionIdNoVersion
import com.neome.api.ent.entMain.msg.MsgAutomationStateInfoList
import com.neome.api.ent.entMain.msg.MsgButtonWorkflowExecute
import com.neome.api.ent.entMain.msg.MsgEntExportExcel
import com.neome.api.ent.entMain.msg.MsgEntFormExport
import com.neome.api.ent.entMain.msg.MsgEntJoin
import com.neome.api.ent.entMain.msg.MsgEntVarSeqIncr
import com.neome.api.ent.entMain.msg.MsgFormMappingResultGet
import com.neome.api.ent.entMain.msg.MsgFormResultCalc
import com.neome.api.ent.entMain.msg.MsgLocationLogPut
import com.neome.api.ent.entMain.msg.MsgPdfMerge
import com.neome.api.ent.entMain.msg.MsgPromptActionsGet
import com.neome.api.ent.entMain.msg.MsgPromptTest
import com.neome.api.ent.entMain.msg.MsgReportOutputFormGet
import com.neome.api.ent.entMain.msg.MsgReportShare
import com.neome.api.ent.entMain.msg.MsgSpreadsheetBulkRowCommentCountGet
import com.neome.api.ent.entMain.msg.MsgSpreadsheetBulkRowGet
import com.neome.api.ent.main.msg.MsgSpreadsheetBulkRowInsert
import com.neome.api.ent.main.msg.MsgSpreadsheetBulkRowUpdate
import com.neome.api.ent.entMain.msg.MsgSpreadsheetClear
import com.neome.api.ent.entMain.msg.MsgSpreadsheetEditorShare
import com.neome.api.ent.entMain.msg.MsgSpreadsheetHistoryFormValue
import com.neome.api.ent.entMain.msg.MsgSpreadsheetHistoryGet
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
import com.neome.api.ent.entMain.msg.MsgSpreadsheetRowsPageGet
import com.neome.api.ent.entMain.msg.MsgUserActionExecute
import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.ent.entMain.msg.MsgWorkflowExecute
import com.neome.api.ent.entMain.msg.MsgWorkflowExecutionId
import com.neome.api.ent.entMain.msg.MsgWorkflowExecutionIdNoVersion
import com.neome.api.ent.entMain.msg.MsgWorkflowExecutionParamUpdate
import com.neome.api.ent.entMain.msg.MsgWorkflowExecutionResume
import com.neome.api.ent.entMain.msg.MsgWorkflowExecutionStateList
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.ent.entMain.sig.SigAuditRecordList
import com.neome.api.ent.entMain.sig.SigAutomationState
import com.neome.api.ent.entMain.sig.SigAutomationStateInfoList
import com.neome.api.ent.entMain.sig.SigDebuggerLogsGet
import com.neome.api.nucleus.base.sig.SigDone
import com.neome.api.ent.entMain.sig.SigEntFormExport
import com.neome.api.ent.entMain.sig.SigEntInvitationList
import com.neome.api.ent.entMain.sig.SigEntUserAvatarListGet
import com.neome.api.ent.entMain.sig.SigEntVarSeq
import com.neome.api.ent.entMain.sig.SigFormMappingResultGet
import com.neome.api.ent.entMain.sig.SigFormValue
import com.neome.api.ent.entMain.sig.SigPdfMerge
import com.neome.api.ent.entMain.sig.SigPromptActions
import com.neome.api.ent.ent.sig.SigReportOutputFormGet
import com.neome.api.ent.main.sig.SigSpreadsheetBulkRowCommentCount
import com.neome.api.home.main.sig.SigSpreadsheetBulkRowGet
import com.neome.api.ent.main.sig.SigSpreadsheetBulkRowInsert
import com.neome.api.ent.entMain.sig.SigSpreadsheetHistoryFormValue
import com.neome.api.home.main.sig.SigSpreadsheetRow
import com.neome.api.home.main.sig.SigSpreadsheetRowCommentCount
import com.neome.api.ent.entMain.sig.SigSpreadsheetRowExpiry
import com.neome.api.ent.entMain.sig.SigSpreadsheetRowRemove
import com.neome.api.ent.entMain.sig.SigSpreadsheetRowSend
import com.neome.api.ent.entMain.sig.SigSpreadsheetRowsPage
import com.neome.api.ent.main.sig.SigTaskId
import com.neome.api.core.deeplink.sig.SigUrl
import com.neome.api.ent.entMain.sig.SigUserActionResult
import com.neome.api.ent.entMain.sig.SigWorkflowExecutionState
import com.neome.api.ent.entMain.sig.SigWorkflowExecutionStateList

class RpcEntMain {
    companion object {
        val SN: ServiceName = ServiceName.entMain

        fun automationExecutionStatusGet(
            entId: EntId,
            msg: MsgAutomationExecutionId,
            sigAcceptor: ISigAcceptor<SigAutomationState>
        ) {
            CallFactory.rpc.create(
                SigAutomationState::class.java,
                entId,
                SN,
                "automationExecutionStatusGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun buttonWorkflowExecute(
            entId: EntId,
            msg: MsgButtonWorkflowExecute,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "buttonWorkflowExecute")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun debuggerLogsGet(entId: EntId, sigAcceptor: ISigAcceptor<SigDebuggerLogsGet>) {
            CallFactory.rpc.create(SigDebuggerLogsGet::class.java, entId, SN, "debuggerLogsGet")
                .sendBearerToken()
                .get(null, sigAcceptor)
        }

        fun entAutomationResume(
            entId: EntId,
            msg: MsgAutomationExecutionId,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "entAutomationResume")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun entAutomationStateClear(entId: EntId, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "entAutomationStateClear")
                .sendBearerToken()
                .delete(null, sigAcceptor)
        }

        fun entAutomationStateInfoListGet(
            entId: EntId,
            msg: MsgAutomationStateInfoList,
            sigAcceptor: ISigAcceptor<SigAutomationStateInfoList>
        ) {
            CallFactory.rpc.create(
                SigAutomationStateInfoList::class.java,
                entId,
                SN,
                "entAutomationStateInfoListGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun entAutomationStateRemove(
            entId: EntId,
            msg: MsgAutomationExecutionIdNoVersion,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "entAutomationStateRemove")
                .sendBearerToken()
                .delete(msg, sigAcceptor)
        }

        fun entExportExcel(msg: MsgEntExportExcel, sigAcceptor: ISigAcceptor<SigTaskId>) {
            CallFactory.rpc.create(
                SigTaskId::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "entExportExcel"
            )
                .sendRefreshToken()
                .post(msg, sigAcceptor)
        }

        fun entFormExport(msg: MsgEntFormExport, sigAcceptor: ISigAcceptor<SigEntFormExport>) {
            CallFactory.rpc.create(
                SigEntFormExport::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "entFormExport"
            )
                .sendRefreshToken()
                .post(msg, sigAcceptor)
        }

        fun entFormMappingResultGet(
            entId: EntId,
            msg: MsgFormMappingResultGet,
            sigAcceptor: ISigAcceptor<SigFormMappingResultGet>
        ) {
            CallFactory.rpc.create(
                SigFormMappingResultGet::class.java,
                entId,
                SN,
                "entFormMappingResultGet"
            )
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun entFormResultCalc(
            entId: EntId,
            msg: MsgFormResultCalc,
            sigAcceptor: ISigAcceptor<SigFormValue>
        ) {
            CallFactory.rpc.create(SigFormValue::class.java, entId, SN, "entFormResultCalc")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun entInvitationListGet(sigAcceptor: ISigAcceptor<SigEntInvitationList>) {
            CallFactory.rpc.create(
                SigEntInvitationList::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "entInvitationListGet"
            )
                .sendBearerToken()
                .get(null, sigAcceptor)
        }

        fun entJoin(msg: MsgEntJoin, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "entJoin")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun entPromptActionsGet(
            entId: EntId,
            msg: MsgPromptActionsGet,
            sigAcceptor: ISigAcceptor<SigPromptActions>
        ) {
            CallFactory.rpc.create(SigPromptActions::class.java, entId, SN, "entPromptActionsGet")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun entPromptExecutorTest(msg: MsgPromptTest, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(
                SigDone::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "entPromptExecutorTest"
            )
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun entReportOutputFormGet(
            entId: EntId,
            msg: MsgReportOutputFormGet,
            sigAcceptor: ISigAcceptor<SigReportOutputFormGet>
        ) {
            CallFactory.rpc.create(
                SigReportOutputFormGet::class.java,
                entId,
                SN,
                "entReportOutputFormGet"
            )
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun entReportShare(entId: EntId, msg: MsgReportShare, sigAcceptor: ISigAcceptor<SigUrl>) {
            CallFactory.rpc.create(SigUrl::class.java, entId, SN, "entReportShare")
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun entSpreadsheetEditorShare(
            entId: EntId,
            msg: MsgSpreadsheetEditorShare,
            sigAcceptor: ISigAcceptor<SigUrl>
        ) {
            CallFactory.rpc.create(SigUrl::class.java, entId, SN, "entSpreadsheetEditorShare")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun entSpreadsheetInsertShare(
            entId: EntId,
            msg: MsgSpreadsheetInsertShare,
            sigAcceptor: ISigAcceptor<SigUrl>
        ) {
            CallFactory.rpc.create(SigUrl::class.java, entId, SN, "entSpreadsheetInsertShare")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun entSpreadsheetRowShare(
            entId: EntId,
            msg: MsgSpreadsheetRowShare,
            sigAcceptor: ISigAcceptor<SigUrl>
        ) {
            CallFactory.rpc.create(SigUrl::class.java, entId, SN, "entSpreadsheetRowShare")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun entUserAvatarListGet(
            entId: EntId,
            msg: MsgVersion,
            sigAcceptor: ISigAcceptor<SigEntUserAvatarListGet>
        ) {
            CallFactory.rpc.create(
                SigEntUserAvatarListGet::class.java,
                entId,
                SN,
                "entUserAvatarListGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun entVarSeqIncr(
            entId: EntId,
            msg: MsgEntVarSeqIncr,
            sigAcceptor: ISigAcceptor<SigEntVarSeq>
        ) {
            CallFactory.rpc.create(SigEntVarSeq::class.java, entId, SN, "entVarSeqIncr")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun locationLogPut(msg: MsgLocationLogPut, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "locationLogPut")
                .sendRefreshToken()
                .put(msg, sigAcceptor)
        }

        fun pdfMerge(entId: EntId, msg: MsgPdfMerge, sigAcceptor: ISigAcceptor<SigPdfMerge>) {
            CallFactory.rpc.create(SigPdfMerge::class.java, entId, SN, "pdfMerge")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun spreadsheetBulkRowCommentCountGet(
            entId: EntId,
            msg: MsgSpreadsheetBulkRowCommentCountGet,
            sigAcceptor: ISigAcceptor<SigSpreadsheetBulkRowCommentCount>
        ) {
            CallFactory.rpc.create(
                SigSpreadsheetBulkRowCommentCount::class.java,
                entId,
                SN,
                "spreadsheetBulkRowCommentCountGet"
            )
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun spreadsheetBulkRowGet(
            entId: EntId,
            msg: MsgSpreadsheetBulkRowGet,
            sigAcceptor: ISigAcceptor<SigSpreadsheetBulkRowGet>
        ) {
            CallFactory.rpc.create(
                SigSpreadsheetBulkRowGet::class.java,
                entId,
                SN,
                "spreadsheetBulkRowGet"
            )
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun spreadsheetBulkRowInsert(
            entId: EntId,
            msg: MsgSpreadsheetBulkRowInsert,
            sigAcceptor: ISigAcceptor<SigSpreadsheetBulkRowInsert>
        ) {
            CallFactory.rpc.create(
                SigSpreadsheetBulkRowInsert::class.java,
                entId,
                SN,
                "spreadsheetBulkRowInsert"
            )
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun spreadsheetBulkRowRemove(
            entId: EntId,
            msg: MsgSpreadsheetRowRemove,
            sigAcceptor: ISigAcceptor<SigTaskId>
        ) {
            CallFactory.rpc.create(SigTaskId::class.java, entId, SN, "spreadsheetBulkRowRemove")
                .sendBearerToken()
                .delete(msg, sigAcceptor)
        }

        fun spreadsheetBulkRowUpdate(
            entId: EntId,
            msg: MsgSpreadsheetBulkRowUpdate,
            sigAcceptor: ISigAcceptor<SigTaskId>
        ) {
            CallFactory.rpc.create(SigTaskId::class.java, entId, SN, "spreadsheetBulkRowUpdate")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun spreadsheetClear(
            entId: EntId,
            msg: MsgSpreadsheetClear,
            sigAcceptor: ISigAcceptor<SigTaskId>
        ) {
            CallFactory.rpc.create(SigTaskId::class.java, entId, SN, "spreadsheetClear")
                .sendBearerToken()
                .delete(msg, sigAcceptor)
        }

        fun spreadsheetHistoryFormValueGet(
            entId: EntId,
            msg: MsgSpreadsheetHistoryFormValue,
            sigAcceptor: ISigAcceptor<SigSpreadsheetHistoryFormValue>
        ) {
            CallFactory.rpc.create(
                SigSpreadsheetHistoryFormValue::class.java,
                entId,
                SN,
                "spreadsheetHistoryFormValueGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun spreadsheetHistoryGet(
            entId: EntId,
            msg: MsgSpreadsheetHistoryGet,
            sigAcceptor: ISigAcceptor<SigAuditRecordList>
        ) {
            CallFactory.rpc.create(
                SigAuditRecordList::class.java,
                entId,
                SN,
                "spreadsheetHistoryGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun spreadsheetPartitionSend(
            entId: EntId,
            msg: MsgSpreadsheetPartitionSend,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "spreadsheetPartitionSend")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun spreadsheetRowCommentCountGet(
            entId: EntId,
            msg: MsgSpreadsheetRowCommentCountGet,
            sigAcceptor: ISigAcceptor<SigSpreadsheetRowCommentCount>
        ) {
            CallFactory.rpc.create(
                SigSpreadsheetRowCommentCount::class.java,
                entId,
                SN,
                "spreadsheetRowCommentCountGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun spreadsheetRowExpiryGet(
            entId: EntId,
            msg: MsgSpreadsheetRowExpiryGet,
            sigAcceptor: ISigAcceptor<SigSpreadsheetRowExpiry>
        ) {
            CallFactory.rpc.create(
                SigSpreadsheetRowExpiry::class.java,
                entId,
                SN,
                "spreadsheetRowExpiryGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun spreadsheetRowGet(
            entId: EntId,
            msg: MsgSpreadsheetRowGet,
            sigAcceptor: ISigAcceptor<SigSpreadsheetRow>
        ) {
            CallFactory.rpc.create(SigSpreadsheetRow::class.java, entId, SN, "spreadsheetRowGet")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun spreadsheetRowMarkRead(
            entId: EntId,
            msg: MsgSpreadsheetRowMarkRead,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "spreadsheetRowMarkRead")
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun spreadsheetRowRemove(
            entId: EntId,
            msg: MsgSpreadsheetRowRemove,
            sigAcceptor: ISigAcceptor<SigSpreadsheetRowRemove>
        ) {
            CallFactory.rpc.create(
                SigSpreadsheetRowRemove::class.java,
                entId,
                SN,
                "spreadsheetRowRemove"
            )
                .sendBearerToken()
                .delete(msg, sigAcceptor)
        }

        fun spreadsheetRowSend(
            entId: EntId,
            msg: MsgSpreadsheetRowSend,
            sigAcceptor: ISigAcceptor<SigSpreadsheetRowSend>
        ) {
            CallFactory.rpc.create(
                SigSpreadsheetRowSend::class.java,
                entId,
                SN,
                "spreadsheetRowSend"
            )
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun spreadsheetRowUpdate(
            entId: EntId,
            msg: MsgSpreadsheetRowUpdate,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "spreadsheetRowUpdate")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun spreadsheetRowsPageGet(
            entId: EntId,
            msg: MsgSpreadsheetRowsPageGet,
            sigAcceptor: ISigAcceptor<SigSpreadsheetRowsPage>
        ) {
            CallFactory.rpc.create(
                SigSpreadsheetRowsPage::class.java,
                entId,
                SN,
                "spreadsheetRowsPageGet"
            )
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun userActionExecute(
            entId: EntId,
            msg: MsgUserActionExecute,
            sigAcceptor: ISigAcceptor<SigUserActionResult>
        ) {
            CallFactory.rpc.create(SigUserActionResult::class.java, entId, SN, "userActionExecute")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun workflowExecute(
            entId: EntId,
            msg: MsgWorkflowExecute,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "workflowExecute")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun workflowExecutionParamUpdate(
            entId: EntId,
            msg: MsgWorkflowExecutionParamUpdate,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "workflowExecutionParamUpdate")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun workflowExecutionResume(
            entId: EntId,
            msg: MsgWorkflowExecutionResume,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "workflowExecutionResume")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun workflowExecutionStateClear(entId: EntId, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "workflowExecutionStateClear")
                .sendBearerToken()
                .delete(null, sigAcceptor)
        }

        fun workflowExecutionStateGet(
            entId: EntId,
            msg: MsgWorkflowExecutionId,
            sigAcceptor: ISigAcceptor<SigWorkflowExecutionState>
        ) {
            CallFactory.rpc.create(
                SigWorkflowExecutionState::class.java,
                entId,
                SN,
                "workflowExecutionStateGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun workflowExecutionStateListGet(
            entId: EntId,
            msg: MsgWorkflowExecutionStateList,
            sigAcceptor: ISigAcceptor<SigWorkflowExecutionStateList>
        ) {
            CallFactory.rpc.create(
                SigWorkflowExecutionStateList::class.java,
                entId,
                SN,
                "workflowExecutionStateListGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun workflowExecutionStateRemove(
            entId: EntId,
            msg: MsgWorkflowExecutionIdNoVersion,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "workflowExecutionStateRemove")
                .sendBearerToken()
                .delete(msg, sigAcceptor)
        }
    }
}
