package com.neome.core.common.serializer.api.ent.entMain.msg

import com.neome.api.ent.base.dto.DtoEntFormExportExcel
import com.neome.api.ent.base.dto.DtoEntSpreadsheetExportExcel
import com.neome.api.ent.entMain.msg.MsgEntExportExcel
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.EntIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgEntExportExcelData(
    @Serializable(with = EntIdSer::class) override val entId: Types.EntId,
    override val formExportConfig: DtoEntFormExportExcel? = null,
    override val spreadsheetExportConfig: DtoEntSpreadsheetExportExcel? = null
) : MsgEntExportExcel
