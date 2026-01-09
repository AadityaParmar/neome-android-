package com.neome.core.common.serializer.api.home.base.dto

import com.neome.api.home.base.dto.DtoMessageReaction
import kotlinx.serialization.Serializable


@Serializable
data class DtoMessageReactionData(
    override val reaction: String,
    override val updatedOn: String
) : DtoMessageReaction
