package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnEventConditionHolder
import com.neome.api.meta.base.dto.DefnEventConditionMap
import com.neome.core.common.serializer.api.meta.base.dto.DefnEventConditionMapData
import com.neome.core.common.serializer.sysId.MetaIdFormEventConditionSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnEventConditionHolderData(
    override val map: Map<@Serializable(with = MetaIdFormEventConditionSer::class) Types.MetaIdFormEventCondition, DefnEventConditionMapData>? = null
) : DefnEventConditionHolder
