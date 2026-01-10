package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldDtoImage
import com.neome.api.meta.base.dto.StudioDtoChatBubbleHeader
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoImageData
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoChatBubbleHeaderData(
    override val image: FieldDtoImageData? = null,
    override val subTitle: String? = null,
    override val title: String? = null
) : StudioDtoChatBubbleHeader
