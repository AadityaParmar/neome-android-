package com.neome.core.common.serializer.api.home.base.dto

import com.neome.api.home.base.dto.DtoChatBubbleHeader
import com.neome.api.meta.base.dto.FieldDtoImage
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoImageData
import kotlinx.serialization.Serializable


@Serializable
data class DtoChatBubbleHeaderData(
    override val image: FieldDtoImageData? = null,
    override val subTitle: String,
    override val title: String
) : DtoChatBubbleHeader
