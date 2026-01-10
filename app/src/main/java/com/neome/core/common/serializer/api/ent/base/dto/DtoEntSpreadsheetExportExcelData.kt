package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntSpreadsheetExportExcel
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutGridSer
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoEntSpreadsheetExportExcelData(
    @Serializable(with = MetaIdLayoutGridSer::class) override val layoutSpreadsheetId: Types.MetaIdLayoutGrid? = null,
    override val rowIdSet: List<@Serializable(with = RowIdSer::class) Types.RowId>? = null,
    @Serializable(with = MetaIdActionSer::class) override val spreadsheetEditorActionId: Types.MetaIdAction
) : DtoEntSpreadsheetExportExcel
