package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnConditionOperator
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioDtoConditionStatement
import com.neome.core.common.serializer.api.meta.base.dto.StudioBuildArgBinderData
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoConditionStatementData(
    override val lhs: StudioBuildArgBinderData? = null,
    override val operator: EnumDefnConditionOperator? = null,
    override val rhs: StudioBuildArgBinderData? = null
) : StudioDtoConditionStatement
