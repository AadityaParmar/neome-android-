package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEventActionBinding
import com.neome.core.common.serializer.sysId.MetaIdFormEventActionBindingSer
import com.neome.core.common.serializer.sysId.MetaIdFormEventActionSer
import com.neome.core.common.serializer.sysId.MetaIdFormEventConditionSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEventActionBindingData(
    @Serializable(with = MetaIdFormEventActionSer::class) override val actionId: Types.MetaIdFormEventAction,
    @Serializable(with = MetaIdFormEventConditionSer::class) override val conditionId: Types.MetaIdFormEventCondition? = null,
    @Serializable(with = MetaIdFormEventActionBindingSer::class) override val metaId: Types.MetaIdFormEventActionBinding,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val notCondition: Boolean? = null
) : StudioEventActionBinding
