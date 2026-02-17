package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnEventCondition
import com.neome.api.meta.base.dto.DefnEventConditionMap
import com.neome.core.common.serializer.api.meta.base.dto.DefnEventConditionData
import com.neome.core.common.serializer.api.meta.base.dto.DefnEventConditionMapData
import com.neome.core.common.serializer.sysId.MetaIdFormEventConditionSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnEventConditionMapData(
    override val andOr: Boolean? = null,
    override val keys: List<@Serializable(with = MetaIdFormEventConditionSer::class) Types.MetaIdFormEventCondition>? = null,
    override val map: Map<@Serializable(with = MetaIdFormEventConditionSer::class) Types.MetaIdFormEventCondition, DefnEventConditionMapData>? = null,
    @Serializable(with = MetaIdFormEventConditionSer::class) override val metaId: Types.MetaIdFormEventCondition,
    override val statement: DefnEventConditionData? = null
) : DefnEventConditionMap
