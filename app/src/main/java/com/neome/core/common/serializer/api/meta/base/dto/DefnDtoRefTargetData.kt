package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnDtoRefTarget
import com.neome.api.meta.base.dto.DefnLayoutGrid
import com.neome.core.common.serializer.api.meta.base.dto.DefnLayoutGridData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnDtoRefTargetData(
    override val displayFieldIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val metaId: Types.MetaIdSpreadsheet,
    override val overrideLayoutSpreadsheet: DefnLayoutGridData
) : DefnDtoRefTarget
