package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FieldSetOfLanguageKeys
import com.neome.core.common.serializer.sysId.LanguageKeySer
import kotlinx.serialization.Serializable


@Serializable
data class FieldSetOfLanguageKeysData(
    override val valueSet: List<@Serializable(with = LanguageKeySer::class) Types.LanguageKey>
) : FieldSetOfLanguageKeys
