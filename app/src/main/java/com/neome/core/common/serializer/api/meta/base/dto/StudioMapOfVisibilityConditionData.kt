package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoVisibilityCondition
import com.neome.api.meta.base.dto.StudioMapOfVisibilityCondition
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoVisibilityConditionData
import com.neome.core.common.serializer.api.meta.base.dto.StudioMapOfVisibilityConditionData
import com.neome.core.common.serializer.sysId.MetaIdVisibilityConditionSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioMapOfVisibilityConditionData(
    override val andOr: Boolean? = null,
    override val keys: List<@Serializable(with = MetaIdVisibilityConditionSer::class) Types.MetaIdVisibilityCondition>? = null,
    override val map: Map<@Serializable(with = MetaIdVisibilityConditionSer::class) Types.MetaIdVisibilityCondition, StudioMapOfVisibilityConditionData>? = null,
    @Serializable(with = MetaIdVisibilityConditionSer::class) override val metaId: Types.MetaIdVisibilityCondition,
    override val statement: StudioDtoVisibilityConditionData? = null
) : StudioMapOfVisibilityCondition
