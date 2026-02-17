package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEventCondition
import com.neome.api.meta.base.dto.StudioEventConditionMap
import com.neome.core.common.serializer.api.meta.base.dto.StudioEventConditionData
import com.neome.core.common.serializer.api.meta.base.dto.StudioEventConditionMapData
import com.neome.core.common.serializer.sysId.MetaIdFormEventConditionSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEventConditionMapData(
    override val andOr: Boolean? = null,
    override val keys: List<@Serializable(with = MetaIdFormEventConditionSer::class) Types.MetaIdFormEventCondition>? = null,
    override val map: Map<@Serializable(with = MetaIdFormEventConditionSer::class) Types.MetaIdFormEventCondition, StudioEventConditionMapData>? = null,
    @Serializable(with = MetaIdFormEventConditionSer::class) override val metaId: Types.MetaIdFormEventCondition,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val statement: StudioEventConditionData? = null
) : StudioEventConditionMap
