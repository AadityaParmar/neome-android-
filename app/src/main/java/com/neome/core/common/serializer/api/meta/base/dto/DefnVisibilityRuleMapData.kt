package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnVisibilityRule
import com.neome.api.meta.base.dto.DefnVisibilityRuleMap
import com.neome.core.common.serializer.sysId.MetaIdVisibilityRuleSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnVisibilityRuleMapData(
    override val keys: Array<@Serializable(with = MetaIdVisibilityRuleSer::class) Types.MetaIdVisibilityRule>,
    override val map: Map<@Serializable(with = MetaIdVisibilityRuleSer::class) Types.MetaIdVisibilityRule, DefnVisibilityRule>
) : DefnVisibilityRuleMap
