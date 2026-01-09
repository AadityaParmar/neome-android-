package com.neome.core.common.serializer.api.ent.entMain.msg

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.ent.entMain.msg.MsgSpreadsheetBulkRowCommentCountGet
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgSpreadsheetBulkRowCommentCountGetData(
    override val version: String? = null,
    override val rowIdCommentVersionMap: Map<@Serializable(with = RowIdSer::class) Types.RowId, String>
) : MsgSpreadsheetBulkRowCommentCountGet
