package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnDtoConditionStatement
import com.neome.api.meta.base.dto.DefnMapOfCondition
import com.neome.api.meta.base.dto.DefnStudioDtoCondition
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoConditionStatementData
import com.neome.core.common.serializer.api.meta.base.dto.DefnMapOfConditionData
import com.neome.core.common.serializer.sysId.MetaIdConditionSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnStudioDtoConditionData(
    override val andOr: Boolean? = null,
    override val keys: List<@Serializable(with = MetaIdConditionSer::class) Types.MetaIdCondition>? = null,
    override val map: Map<@Serializable(with = MetaIdConditionSer::class) Types.MetaIdCondition, DefnMapOfConditionData>? = null,
    @Serializable(with = MetaIdConditionSer::class) override val metaId: Types.MetaIdCondition,
    override val statement: DefnDtoConditionStatementData? = null,
    override val negation: Boolean? = null
) : DefnStudioDtoCondition
