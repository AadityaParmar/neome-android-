package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntSpreadsheet
import com.neome.api.meta.base.dto.StudioEntSpreadsheetMap
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntSpreadsheetMapData(
    override val keys: Array<@Serializable(with = MetaIdSpreadsheetSer::class) Types.MetaIdSpreadsheet>,
    override val map: Map<@Serializable(with = MetaIdSpreadsheetSer::class) Types.MetaIdSpreadsheet, StudioEntSpreadsheet>
) : StudioEntSpreadsheetMap
