package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioValueVarIdCondition
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioValueVarIdConditionData(
    @Serializable(with = MetaIdVarSer::class) override val condVarId: Types.MetaIdVar,
    override val negation: Boolean? = null
) : StudioValueVarIdCondition
