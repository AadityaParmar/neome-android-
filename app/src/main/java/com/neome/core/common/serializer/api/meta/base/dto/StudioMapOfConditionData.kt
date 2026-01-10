package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoConditionStatement
import com.neome.api.meta.base.dto.StudioMapOfCondition
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoConditionStatementData
import com.neome.core.common.serializer.api.meta.base.dto.StudioMapOfConditionData
import com.neome.core.common.serializer.sysId.MetaIdConditionSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioMapOfConditionData(
    override val andOr: Boolean? = null,
    override val keys: List<@Serializable(with = MetaIdConditionSer::class) Types.MetaIdCondition>? = null,
    override val map: Map<@Serializable(with = MetaIdConditionSer::class) Types.MetaIdCondition, StudioMapOfConditionData>? = null,
    @Serializable(with = MetaIdConditionSer::class) override val metaId: Types.MetaIdCondition,
    override val statement: StudioDtoConditionStatementData? = null
) : StudioMapOfCondition
