package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEventConditionHolder
import com.neome.api.meta.base.dto.StudioEventConditionMap
import com.neome.core.common.serializer.api.meta.base.dto.StudioEventConditionMapData
import com.neome.core.common.serializer.sysId.MetaIdFormEventConditionSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEventConditionHolderData(
    override val map: Map<@Serializable(with = MetaIdFormEventConditionSer::class) Types.MetaIdFormEventCondition, StudioEventConditionMapData>? = null
) : StudioEventConditionHolder
