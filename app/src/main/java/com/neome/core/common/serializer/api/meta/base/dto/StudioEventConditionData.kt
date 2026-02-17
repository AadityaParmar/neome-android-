package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnEventOperator
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioEventCondition
import com.neome.core.common.serializer.api.meta.base.dto.StudioBuildArgBinderData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEventConditionData(
    @Serializable(with = MetaIdFieldSer::class) override val lhs: Types.MetaIdField,
    override val operator: EnumDefnEventOperator,
    override val rhs: StudioBuildArgBinderData? = null
) : StudioEventCondition
