package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoUserConditionStatement
import com.neome.api.meta.base.dto.StudioMapOfUserCondition
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoUserConditionStatementData
import com.neome.core.common.serializer.api.meta.base.dto.StudioMapOfUserConditionData
import com.neome.core.common.serializer.sysId.MetaIdUserConditionSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioMapOfUserConditionData(
    override val andOr: Boolean? = null,
    override val keys: List<@Serializable(with = MetaIdUserConditionSer::class) Types.MetaIdUserCondition>? = null,
    override val map: Map<@Serializable(with = MetaIdUserConditionSer::class) Types.MetaIdUserCondition, StudioMapOfUserConditionData>? = null,
    @Serializable(with = MetaIdUserConditionSer::class) override val metaId: Types.MetaIdUserCondition,
    override val statement: StudioDtoUserConditionStatementData? = null
) : StudioMapOfUserCondition
