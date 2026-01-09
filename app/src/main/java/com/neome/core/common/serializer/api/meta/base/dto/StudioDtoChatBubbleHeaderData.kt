package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldDtoImage
import com.neome.api.meta.base.dto.StudioDtoChatBubbleHeader
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoChatBubbleHeaderData(
    override val image: FieldDtoImage? = null,
    override val subTitle: String? = null,
    override val title: String? = null
) : StudioDtoChatBubbleHeader
