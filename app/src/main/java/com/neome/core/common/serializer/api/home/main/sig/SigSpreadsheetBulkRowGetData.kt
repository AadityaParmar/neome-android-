package com.neome.core.common.serializer.api.home.main.sig

import com.neome.api.home.main.sig.SigSpreadsheetBulkRowGet
import com.neome.api.home.main.sig.SigSpreadsheetRow
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.api.home.main.sig.SigSpreadsheetRowData
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigSpreadsheetBulkRowGetData(
    override val expiredRowIdSet: Set<@Serializable(with = RowIdSer::class) Types.RowId>? = null,
    override val inProgressRowIdSet: Set<@Serializable(with = RowIdSer::class) Types.RowId>? = null,
    override val rowMap: Map<@Serializable(with = RowIdSer::class) Types.RowId, SigSpreadsheetRowData>? = null
) : SigSpreadsheetBulkRowGet
