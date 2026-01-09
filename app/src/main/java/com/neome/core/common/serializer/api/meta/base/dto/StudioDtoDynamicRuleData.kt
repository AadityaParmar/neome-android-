package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumStudioCompType
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoDynamicRule
import com.neome.api.meta.base.dto.StudioMapOfFieldDynamicCondition
import com.neome.core.common.serializer.sysId.MetaIdFieldDynamicRuleSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoDynamicRuleData(
    override val conditionNode: StudioMapOfFieldDynamicCondition? = null,
    override val fieldType: EnumStudioCompType,
    @Serializable(with = MetaIdFieldDynamicRuleSer::class) override val metaId: Types.MetaIdFieldDynamicRule,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    @Serializable(with = MetaIdVarSer::class) override val sourceVarId: Types.MetaIdVar? = null
) : StudioDtoDynamicRule
