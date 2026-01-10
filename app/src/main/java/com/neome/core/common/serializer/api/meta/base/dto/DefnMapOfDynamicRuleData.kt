package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnDtoDynamicRule
import com.neome.api.meta.base.dto.DefnMapOfDynamicRule
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoDynamicRuleData
import com.neome.core.common.serializer.sysId.MetaIdFieldDynamicRuleSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnMapOfDynamicRuleData(
    override val keys: List<@Serializable(with = MetaIdFieldDynamicRuleSer::class) Types.MetaIdFieldDynamicRule>,
    override val map: Map<@Serializable(with = MetaIdFieldDynamicRuleSer::class) Types.MetaIdFieldDynamicRule, DefnDtoDynamicRuleData>
) : DefnMapOfDynamicRule
