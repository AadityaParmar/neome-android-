package com.neome.core.common.serializer.api.ent.ent.sig

import com.neome.api.ent.ent.sig.SigEntSpreadsheetData
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigEntSpreadsheetDataData(
    override val rowMap: Map<@Serializable(with = RowIdSer::class) Types.RowId, FormValueRaw>,
    override val topGridVer: String? = null
) : SigEntSpreadsheetData
