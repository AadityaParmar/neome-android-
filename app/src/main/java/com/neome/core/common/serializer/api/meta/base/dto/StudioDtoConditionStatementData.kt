package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnConditionOperator
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioDtoConditionStatement
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoConditionStatementData(
    override val lhs: StudioBuildArgBinder? = null,
    override val operator: EnumDefnConditionOperator? = null,
    override val rhs: StudioBuildArgBinder? = null
) : StudioDtoConditionStatement
