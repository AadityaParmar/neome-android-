package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.dto.DefnDtoDynamicRule
import com.neome.api.meta.base.dto.DefnMapOfDynamicCondition
import com.neome.api.meta.base.dto.DefnStudioMapOfDtoOption
import com.neome.core.common.serializer.sysId.MetaIdFieldDynamicRuleSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnDtoDynamicRuleData(
    override val conditionNode: DefnMapOfDynamicCondition,
    override val fieldType: EnumDefnCompType,
    @Serializable(with = MetaIdFieldDynamicRuleSer::class) override val metaId: Types.MetaIdFieldDynamicRule,
    override val optionMap: DefnStudioMapOfDtoOption? = null
) : DefnDtoDynamicRule
