package com.neome.core.common.serializer.api.ent.main.msg

import com.neome.api.ent.main.msg.MsgSpreadsheetBulkRowInsert
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgSpreadsheetBulkRowInsertData(
    override val rowMap: Map<@Serializable(with = RowIdSer::class) Types.RowId, FormValueRawData>,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val spreadsheetId: Types.MetaIdSpreadsheet
) : MsgSpreadsheetBulkRowInsert
