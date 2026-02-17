package com.neome.core.common.serializer.api.ent.ent.msg

import com.neome.api.ent.ent.msg.MsgEntSpreadsheetPartitionRowIdList
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgEntSpreadsheetPartitionRowIdListData(
    override val pageSize: Long,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val spreadsheetId: Types.MetaIdSpreadsheet,
    override val toRowOrderVer: String
) : MsgEntSpreadsheetPartitionRowIdList
