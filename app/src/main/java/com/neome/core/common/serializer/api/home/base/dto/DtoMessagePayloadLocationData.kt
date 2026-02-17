package com.neome.core.common.serializer.api.home.base.dto

import com.neome.api.home.base.Types.EnumMessageType
import com.neome.api.home.base.dto.DtoMessagePayloadLocation
import com.neome.api.home.base.dto.DtoMessagePayloadText
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadSeal
import com.neome.core.common.serializer.sysId.ContactIdSer
import com.neome.core.common.serializer.sysId.MediaIdImageSer
import kotlinx.serialization.Serializable


@Serializable
sealed interface DtoMessagePayloadLocationSeal : DtoMessagePayloadLocation


@Serializable
data class DtoMessagePayloadLocationData(
    override val isForwarded: Boolean? = null,
    override val mentionMap: Map<String, @Serializable(with = ContactIdSer::class) Types.ContactId>? = null,
    override val messageType: EnumMessageType = EnumMessageType.location,
    override val isUpdated: Boolean? = null,
    override val text: String,
    override val city: String? = null,
    override val country: String? = null,
    override val latitude: Double,
    override val longitude: Double,
    @Serializable(with = MediaIdImageSer::class) override val mediaIdImage: Types.MediaIdImage
) : DtoMessagePayloadSeal, DtoMessagePayloadLocation
