package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoDynamicRule
import com.neome.api.meta.base.dto.StudioMapOfDynamicRule
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoDynamicRuleData
import com.neome.core.common.serializer.sysId.MetaIdFieldDynamicRuleSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioMapOfDynamicRuleData(
    override val keys: List<@Serializable(with = MetaIdFieldDynamicRuleSer::class) Types.MetaIdFieldDynamicRule>,
    override val map: Map<@Serializable(with = MetaIdFieldDynamicRuleSer::class) Types.MetaIdFieldDynamicRule, StudioDtoDynamicRuleData>
) : StudioMapOfDynamicRule
