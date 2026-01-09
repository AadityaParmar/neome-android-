package com.neome.core.common.serializer.api.ent.main.sig

import com.neome.api.ent.main.sig.SigSpreadsheetBulkRowCommentCount
import com.neome.api.home.main.sig.SigSpreadsheetRowCommentCount
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EnvValidationError
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigSpreadsheetBulkRowCommentCountData(
    override val errorMap: Map<@Serializable(with = RowIdSer::class) Types.RowId, EnvValidationError>? = null,
    override val rowCommentCountMap: Map<@Serializable(with = RowIdSer::class) Types.RowId, SigSpreadsheetRowCommentCount>? = null
) : SigSpreadsheetBulkRowCommentCount
