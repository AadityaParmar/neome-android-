package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.DtoCarouselTemplateGroup
import kotlinx.serialization.Serializable


@Serializable
data class DtoCarouselTemplateGroupData(
    override val numberOfCardParams: Long,
    override val numberOfCards: Long,
    override val numberOfHeaderMessageParams: Long
) : DtoCarouselTemplateGroup
