package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnVisibilityCondition
import com.neome.api.meta.base.dto.DefnVisibilityConditionMap
import com.neome.core.common.serializer.sysId.MetaIdVisibilityConditionSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnVisibilityConditionMapData(
    override val andOr: Boolean? = null,
    override val keys: Array<@Serializable(with = MetaIdVisibilityConditionSer::class) Types.MetaIdVisibilityCondition>? = null,
    override val map: Map<@Serializable(with = MetaIdVisibilityConditionSer::class) Types.MetaIdVisibilityCondition, DefnVisibilityConditionMap>? = null,
    @Serializable(with = MetaIdVisibilityConditionSer::class) override val metaId: Types.MetaIdVisibilityCondition,
    override val statement: DefnVisibilityCondition? = null
) : DefnVisibilityConditionMap
