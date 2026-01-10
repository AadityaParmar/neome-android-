package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnDtoDynamicCondition
import com.neome.api.meta.base.dto.DefnMapOfDynamicCondition
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoDynamicConditionData
import com.neome.core.common.serializer.api.meta.base.dto.DefnMapOfDynamicConditionData
import com.neome.core.common.serializer.sysId.MetaIdFieldDynamicConditionSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnMapOfDynamicConditionData(
    override val andOr: Boolean? = null,
    override val keys: List<@Serializable(with = MetaIdFieldDynamicConditionSer::class) Types.MetaIdFieldDynamicCondition>? = null,
    override val map: Map<@Serializable(with = MetaIdFieldDynamicConditionSer::class) Types.MetaIdFieldDynamicCondition, DefnMapOfDynamicConditionData>? = null,
    @Serializable(with = MetaIdFieldDynamicConditionSer::class) override val metaId: Types.MetaIdFieldDynamicCondition,
    override val statement: DefnDtoDynamicConditionData? = null
) : DefnMapOfDynamicCondition
