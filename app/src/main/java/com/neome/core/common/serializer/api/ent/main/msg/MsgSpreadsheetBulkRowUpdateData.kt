package com.neome.core.common.serializer.api.ent.main.msg

import com.neome.api.ent.main.msg.MsgSpreadsheetBulkRowUpdate
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.MetaIdCompSer
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement


@Serializable
data class MsgSpreadsheetBulkRowUpdateData(
    @Serializable(with = MetaIdActionSer::class) override val actionId: Types.MetaIdAction,
    override val rowIdSet: Array<@Serializable(with = RowIdSer::class) Types.RowId>,
    override val valueMap: Map<@Serializable(with = MetaIdCompSer::class) Types.MetaIdComp, JsonElement>
) : MsgSpreadsheetBulkRowUpdate
