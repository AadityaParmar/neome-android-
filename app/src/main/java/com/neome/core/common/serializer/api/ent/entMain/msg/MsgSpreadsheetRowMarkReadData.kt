package com.neome.core.common.serializer.api.ent.entMain.msg

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.ent.entMain.msg.MsgSpreadsheetRowMarkRead
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgSpreadsheetRowMarkReadData(
    override val version: String? = null,
    override val formValueRaw: FormValueRawData,
    @Serializable(with = RowIdSer::class) override val rowId: Types.RowId,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val spreadsheetId: Types.MetaIdSpreadsheet
) : MsgSpreadsheetRowMarkRead
