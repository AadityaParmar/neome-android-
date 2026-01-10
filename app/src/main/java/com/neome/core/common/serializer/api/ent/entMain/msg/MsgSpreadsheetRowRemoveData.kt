package com.neome.core.common.serializer.api.ent.entMain.msg

import com.neome.api.ent.entMain.msg.MsgSpreadsheetRowRemove
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgSpreadsheetRowRemoveData(
    @Serializable(with = MetaIdFormSer::class) override val formId: Types.MetaIdForm,
    @Serializable(with = RowIdSer::class) override val rowId: Types.RowId? = null,
    override val rowIdSet: List<@Serializable(with = RowIdSer::class) Types.RowId>? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val spreadsheetId: Types.MetaIdSpreadsheet,
    override val transactionId: String? = null
) : MsgSpreadsheetRowRemove
