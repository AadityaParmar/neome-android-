package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.TranslatePath
import com.neome.api.meta.base.dto.TranslateResult
import kotlinx.serialization.Serializable


@Serializable
data class TranslateResultData(
    override val translateMap: Map<String, Array<TranslatePath>>
) : TranslateResult
