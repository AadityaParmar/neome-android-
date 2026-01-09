package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioMapOfVisibilityCondition
import com.neome.api.meta.base.dto.StudioVisibilityActionMap
import com.neome.api.meta.base.dto.StudioVisibilityRule
import com.neome.core.common.serializer.sysId.MetaIdVisibilityRuleSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioVisibilityRuleData(
    override val actionMapIfFalse: StudioVisibilityActionMap,
    override val actionMapIfTrue: StudioVisibilityActionMap,
    override val description: String? = null,
    @Serializable(with = MetaIdVisibilityRuleSer::class) override val metaId: Types.MetaIdVisibilityRule,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val visibilityCondMap: StudioMapOfVisibilityCondition? = null
) : StudioVisibilityRule
