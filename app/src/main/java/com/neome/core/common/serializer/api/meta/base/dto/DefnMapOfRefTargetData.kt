package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnDtoRefTarget
import com.neome.api.meta.base.dto.DefnMapOfRefTarget
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnMapOfRefTargetData(
    override val keys: Array<@Serializable(with = MetaIdSpreadsheetSer::class) Types.MetaIdSpreadsheet>,
    override val map: Map<@Serializable(with = MetaIdSpreadsheetSer::class) Types.MetaIdSpreadsheet, DefnDtoRefTarget>
) : DefnMapOfRefTarget
