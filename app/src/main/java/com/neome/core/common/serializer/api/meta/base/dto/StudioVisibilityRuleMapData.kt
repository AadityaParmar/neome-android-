package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioVisibilityRule
import com.neome.api.meta.base.dto.StudioVisibilityRuleMap
import com.neome.core.common.serializer.sysId.MetaIdVisibilityRuleSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioVisibilityRuleMapData(
    override val keys: Array<@Serializable(with = MetaIdVisibilityRuleSer::class) Types.MetaIdVisibilityRule>,
    override val map: Map<@Serializable(with = MetaIdVisibilityRuleSer::class) Types.MetaIdVisibilityRule, StudioVisibilityRule>
) : StudioVisibilityRuleMap
