package com.neome.core.common.serializer.api.ent.entMain.msg

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.ent.entMain.msg.MsgSpreadsheetRowExpiryGet
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.SpreadsheetPartitionIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgSpreadsheetRowExpiryGetData(
    override val version: String? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val spreadsheetId: Types.MetaIdSpreadsheet,
    @Serializable(with = SpreadsheetPartitionIdSer::class) override val spreadsheetPartitionId: Types.SpreadsheetPartitionId
) : MsgSpreadsheetRowExpiryGet
