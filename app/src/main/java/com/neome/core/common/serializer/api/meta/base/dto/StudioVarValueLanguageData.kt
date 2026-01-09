package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioVarValueLanguage
import com.neome.core.common.serializer.sysId.LanguageKeySer
import kotlinx.serialization.Serializable


@Serializable
data class StudioVarValueLanguageData(
    @Serializable(with = LanguageKeySer::class) override val value: Types.LanguageKey
) : StudioVarValueLanguage
