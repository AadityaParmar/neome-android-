// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.ent.entAside.msg.MsgButtonFieldReportDataGet
import com.neome.api.ent.entAside.msg.MsgEntLogNumberFieldDataGet
import com.neome.api.ent.entAside.msg.MsgEntUserPickerCandidateListGet
import com.neome.api.ent.entAside.msg.MsgPluginApiOutput
import com.neome.api.ent.entAside.msg.MsgRefFieldDataPaginatedGet
import com.neome.api.ent.entAside.msg.MsgReportFieldDataGet
import com.neome.api.ent.entAside.msg.MsgSpreadsheetRefFieldDataGet
import com.neome.api.ent.entAside.sig.SigEntInfo
import com.neome.api.ent.entAside.sig.SigEntLogNumberFieldDataGet
import com.neome.api.ent.entAside.sig.SigEntUserPickerCandidateListGet
import com.neome.api.ent.entAside.sig.SigPluginApiOutput
import com.neome.api.ent.entAside.sig.SigReportFieldData
import com.neome.api.ent.entAside.sig.SigSpreadsheetRefFieldData
import com.neome.api.ent.entMain.sig.SigOutputFormValue
import com.neome.api.ent.entMain.sig.SigSpreadsheetRowsPage
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ISigAcceptor

class WsocEntAside {
    companion object {
        val SN: ServiceName = ServiceName.entAside

        fun entButtonFieldReportDataGet(
            entId: EntId,
            msg: MsgButtonFieldReportDataGet,
            sigAcceptor: ISigAcceptor<SigOutputFormValue>
        ) {
            CallFactory.wsoc.create(
                SigOutputFormValue::class.java,
                entId,
                SN,
                "entButtonFieldReportDataGet"
            )
                .post(msg, sigAcceptor)
        }

        fun entInfoGet(entId: EntId, msg: MsgVersion, sigAcceptor: ISigAcceptor<SigEntInfo>) {
            CallFactory.wsoc.create(SigEntInfo::class.java, entId, SN, "entInfoGet")
                .get(msg, sigAcceptor)
        }

        fun entLogNumberFieldDataGet(
            entId: EntId,
            msg: MsgEntLogNumberFieldDataGet,
            sigAcceptor: ISigAcceptor<SigEntLogNumberFieldDataGet>
        ) {
            CallFactory.wsoc.create(
                SigEntLogNumberFieldDataGet::class.java,
                entId,
                SN,
                "entLogNumberFieldDataGet"
            )
                .get(msg, sigAcceptor)
        }

        fun entRefFieldPaginatedDataGet(
            entId: EntId,
            msg: MsgRefFieldDataPaginatedGet,
            sigAcceptor: ISigAcceptor<SigSpreadsheetRowsPage>
        ) {
            CallFactory.wsoc.create(
                SigSpreadsheetRowsPage::class.java,
                entId,
                SN,
                "entRefFieldPaginatedDataGet"
            )
                .post(msg, sigAcceptor)
        }

        fun entReportFieldDataGet(
            entId: EntId,
            msg: MsgReportFieldDataGet,
            sigAcceptor: ISigAcceptor<SigReportFieldData>
        ) {
            CallFactory.wsoc.create(
                SigReportFieldData::class.java,
                entId,
                SN,
                "entReportFieldDataGet"
            )
                .post(msg, sigAcceptor)
        }

        fun entSpreadsheetRefFieldDataGet(
            entId: EntId,
            msg: MsgSpreadsheetRefFieldDataGet,
            sigAcceptor: ISigAcceptor<SigSpreadsheetRefFieldData>
        ) {
            CallFactory.wsoc.create(
                SigSpreadsheetRefFieldData::class.java,
                entId,
                SN,
                "entSpreadsheetRefFieldDataGet"
            )
                .post(msg, sigAcceptor)
        }

        fun entUserPickerCandidateListGet(
            entId: EntId,
            msg: MsgEntUserPickerCandidateListGet,
            sigAcceptor: ISigAcceptor<SigEntUserPickerCandidateListGet>
        ) {
            CallFactory.wsoc.create(
                SigEntUserPickerCandidateListGet::class.java,
                entId,
                SN,
                "entUserPickerCandidateListGet"
            )
                .post(msg, sigAcceptor)
        }

        fun pluginApiOutputGet(
            entId: EntId,
            msg: MsgPluginApiOutput,
            sigAcceptor: ISigAcceptor<SigPluginApiOutput>
        ) {
            CallFactory.wsoc.create(SigPluginApiOutput::class.java, entId, SN, "pluginApiOutputGet")
                .post(msg, sigAcceptor)
        }
    }
}
