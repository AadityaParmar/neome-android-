package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoRefTarget
import com.neome.api.meta.base.dto.StudioValueVarIdCondition
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueVarIdConditionData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutGridSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoRefTargetData(
    override val displayFieldIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val filterConditionVarId: StudioValueVarIdConditionData? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val metaId: Types.MetaIdSpreadsheet,
    @Serializable(with = SymbolSer::class) override val name: Symbol? = null,
    @Serializable(with = MetaIdLayoutGridSer::class) override val overrideLayoutSpreadsheetId: Types.MetaIdLayoutGrid? = null
) : StudioDtoRefTarget
