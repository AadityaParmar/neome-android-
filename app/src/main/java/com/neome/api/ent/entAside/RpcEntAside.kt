// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.ent.entAside.msg.MsgButtonFieldReportDataGet
import com.neome.api.ent.entAside.msg.MsgEntLogNumberFieldDataGet
import com.neome.api.ent.entAside.msg.MsgEntUserPickerCandidateListGet
import com.neome.api.ent.entAside.msg.MsgPaymentStatus
import com.neome.api.ent.entAside.msg.MsgPaymentVerify
import com.neome.api.ent.entAside.msg.MsgPluginApiOutput
import com.neome.api.ent.entAside.msg.MsgRefFieldDataPaginatedGet
import com.neome.api.ent.entAside.msg.MsgReportFieldDataGet
import com.neome.api.ent.entAside.msg.MsgSpreadsheetRefFieldDataGet
import com.neome.api.ent.entAside.msg.MsgSpreadsheetRowsGet
import com.neome.api.ent.entAside.sig.SigEntInfo
import com.neome.api.ent.entAside.sig.SigEntLogNumberFieldDataGet
import com.neome.api.ent.entAside.sig.SigEntUserPickerCandidateListGet
import com.neome.api.ent.entAside.sig.SigPaymentStatus
import com.neome.api.ent.entAside.sig.SigPluginApiOutput
import com.neome.api.ent.entAside.sig.SigReportFieldData
import com.neome.api.ent.entAside.sig.SigSpreadsheetRefFieldData
import com.neome.api.ent.entAside.sig.SigSpreadsheetRowsGet
import com.neome.api.ent.entMain.sig.SigOutputFormValue
import com.neome.api.ent.entMain.sig.SigSpreadsheetRowsPage
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.nucleus.base.sig.SigDone

class RpcEntAside {
    companion object {
        val SN: ServiceName = ServiceName.entAside

        fun entButtonFieldReportDataGet(
            entId: EntId,
            msg: MsgButtonFieldReportDataGet,
            sigAcceptor: ISigAcceptor<SigOutputFormValue>
        ) {
            CallFactory.rpc.create(
                SigOutputFormValue::class.java,
                entId,
                SN,
                "entButtonFieldReportDataGet"
            )
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun entInfoGet(entId: EntId, msg: MsgVersion, sigAcceptor: ISigAcceptor<SigEntInfo>) {
            CallFactory.rpc.create(SigEntInfo::class.java, entId, SN, "entInfoGet")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun entLogNumberFieldDataGet(
            entId: EntId,
            msg: MsgEntLogNumberFieldDataGet,
            sigAcceptor: ISigAcceptor<SigEntLogNumberFieldDataGet>
        ) {
            CallFactory.rpc.create(
                SigEntLogNumberFieldDataGet::class.java,
                entId,
                SN,
                "entLogNumberFieldDataGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun entPaymentStatusGet(
            entId: EntId,
            msg: MsgPaymentStatus,
            sigAcceptor: ISigAcceptor<SigPaymentStatus>
        ) {
            CallFactory.rpc.create(SigPaymentStatus::class.java, entId, SN, "entPaymentStatusGet")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun entPaymentVerify(
            entId: EntId,
            msg: MsgPaymentVerify,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "entPaymentVerify")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun entRefFieldPaginatedDataGet(
            entId: EntId,
            msg: MsgRefFieldDataPaginatedGet,
            sigAcceptor: ISigAcceptor<SigSpreadsheetRowsPage>
        ) {
            CallFactory.rpc.create(
                SigSpreadsheetRowsPage::class.java,
                entId,
                SN,
                "entRefFieldPaginatedDataGet"
            )
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun entReportFieldDataGet(
            entId: EntId,
            msg: MsgReportFieldDataGet,
            sigAcceptor: ISigAcceptor<SigReportFieldData>
        ) {
            CallFactory.rpc.create(
                SigReportFieldData::class.java,
                entId,
                SN,
                "entReportFieldDataGet"
            )
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun entSpreadsheetRefFieldDataGet(
            entId: EntId,
            msg: MsgSpreadsheetRefFieldDataGet,
            sigAcceptor: ISigAcceptor<SigSpreadsheetRefFieldData>
        ) {
            CallFactory.rpc.create(
                SigSpreadsheetRefFieldData::class.java,
                entId,
                SN,
                "entSpreadsheetRefFieldDataGet"
            )
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun entSpreadsheetRowsGet(
            entId: EntId,
            msg: MsgSpreadsheetRowsGet,
            sigAcceptor: ISigAcceptor<SigSpreadsheetRowsGet>
        ) {
            CallFactory.rpc.create(
                SigSpreadsheetRowsGet::class.java,
                entId,
                SN,
                "entSpreadsheetRowsGet"
            )
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun entUserPickerCandidateListGet(
            entId: EntId,
            msg: MsgEntUserPickerCandidateListGet,
            sigAcceptor: ISigAcceptor<SigEntUserPickerCandidateListGet>
        ) {
            CallFactory.rpc.create(
                SigEntUserPickerCandidateListGet::class.java,
                entId,
                SN,
                "entUserPickerCandidateListGet"
            )
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun pluginApiOutputGet(
            entId: EntId,
            msg: MsgPluginApiOutput,
            sigAcceptor: ISigAcceptor<SigPluginApiOutput>
        ) {
            CallFactory.rpc.create(SigPluginApiOutput::class.java, entId, SN, "pluginApiOutputGet")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }
    }
}
