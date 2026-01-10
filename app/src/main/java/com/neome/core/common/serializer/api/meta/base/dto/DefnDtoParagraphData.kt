package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoParagraph
import kotlinx.serialization.Serializable


@Serializable
data class DefnDtoParagraphData(
    override val value: List<String>? = null
) : DefnDtoParagraph
