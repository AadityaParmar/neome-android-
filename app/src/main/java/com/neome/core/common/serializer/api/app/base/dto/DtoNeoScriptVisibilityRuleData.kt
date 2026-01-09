package com.neome.core.common.serializer.api.app.base.dto

import com.neome.api.app.base.Types.EnumKindNeoScript
import com.neome.api.app.base.dto.DtoNeoScript
import com.neome.api.app.base.dto.DtoNeoScriptVisibilityRule
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdVisibilityRuleSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoNeoScriptVisibilityRuleData(
    override val kind: EnumKindNeoScript,
    @Serializable(with = MetaIdFormSer::class) override val formId: Types.MetaIdForm? = null,
    @Serializable(with = MetaIdVisibilityRuleSer::class) override val visibilityRuleId: Types.MetaIdVisibilityRule? = null
) : DtoNeoScriptVisibilityRule
