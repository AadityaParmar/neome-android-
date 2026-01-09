package com.neome.core.common.serializer.api.ent.ent.msg

import com.neome.api.ent.ent.msg.MsgEntSpreadsheetData
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgEntSpreadsheetDataData(
    override val fromGridVer: String? = null,
    override val pageSize: Long? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val spreadsheetId: Types.MetaIdSpreadsheet,
    override val toGridVer: String
) : MsgEntSpreadsheetData
