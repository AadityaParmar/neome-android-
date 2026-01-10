package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoFieldDynamicCondition
import com.neome.api.meta.base.dto.StudioMapOfFieldDynamicCondition
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoFieldDynamicConditionData
import com.neome.core.common.serializer.api.meta.base.dto.StudioMapOfFieldDynamicConditionData
import com.neome.core.common.serializer.sysId.MetaIdFieldDynamicConditionSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioMapOfFieldDynamicConditionData(
    override val andOr: Boolean? = null,
    override val keys: List<@Serializable(with = MetaIdFieldDynamicConditionSer::class) Types.MetaIdFieldDynamicCondition>? = null,
    override val map: Map<@Serializable(with = MetaIdFieldDynamicConditionSer::class) Types.MetaIdFieldDynamicCondition, StudioMapOfFieldDynamicConditionData>? = null,
    @Serializable(with = MetaIdFieldDynamicConditionSer::class) override val metaId: Types.MetaIdFieldDynamicCondition,
    override val statement: StudioDtoFieldDynamicConditionData? = null
) : StudioMapOfFieldDynamicCondition
