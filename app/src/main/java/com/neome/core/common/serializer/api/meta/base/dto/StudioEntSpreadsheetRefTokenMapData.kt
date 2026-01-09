package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntSpreadsheetRefTokenMap
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetRefSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntSpreadsheetRefTokenMapData(
    override val refTokenMap: Map<@Serializable(with = MetaIdSpreadsheetRefSer::class) Types.MetaIdSpreadsheetRef, String>? = null
) : StudioEntSpreadsheetRefTokenMap
