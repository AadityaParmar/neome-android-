package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnVisibilityActionMap
import com.neome.api.meta.base.dto.DefnVisibilityConditionMap
import com.neome.api.meta.base.dto.DefnVisibilityRule
import com.neome.core.common.serializer.sysId.MetaIdVisibilityRuleSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnVisibilityRuleData(
    override val actionMapIfFalse: DefnVisibilityActionMap,
    override val actionMapIfTrue: DefnVisibilityActionMap,
    override val conditionNode: DefnVisibilityConditionMap,
    @Serializable(with = MetaIdVisibilityRuleSer::class) override val metaId: Types.MetaIdVisibilityRule
) : DefnVisibilityRule
