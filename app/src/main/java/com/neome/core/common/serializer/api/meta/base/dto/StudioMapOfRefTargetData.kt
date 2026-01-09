package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoRefTarget
import com.neome.api.meta.base.dto.StudioMapOfRefTarget
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioMapOfRefTargetData(
    override val keys: Array<@Serializable(with = MetaIdSpreadsheetSer::class) Types.MetaIdSpreadsheet>,
    override val map: Map<@Serializable(with = MetaIdSpreadsheetSer::class) Types.MetaIdSpreadsheet, StudioDtoRefTarget>
) : StudioMapOfRefTarget
