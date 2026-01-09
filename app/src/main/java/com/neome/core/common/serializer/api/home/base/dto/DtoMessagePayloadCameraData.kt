package com.neome.core.common.serializer.api.home.base.dto

import com.neome.api.home.base.Types.EnumMessageType
import com.neome.api.home.base.dto.DtoMessagePayloadCamera
import com.neome.api.home.base.dto.DtoMessagePayloadImage
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadSeal
import com.neome.core.common.serializer.sysId.ContactIdSer
import com.neome.core.common.serializer.sysId.MediaIdImageSer
import kotlinx.serialization.Serializable


@Serializable
sealed interface DtoMessagePayloadCameraSeal : DtoMessagePayloadCamera


@Serializable
data class DtoMessagePayloadCameraData(
    override val isForwarded: Boolean? = null,
    override val mentionMap: Map<String, @Serializable(with = ContactIdSer::class) Types.ContactId>? = null,
    override val messageType: EnumMessageType,
    override val isUpdated: Boolean? = null,
    override val text: String,
    override val fileSize: Long? = null,
    override val height: Long? = null,
    @Serializable(with = MediaIdImageSer::class) override val mediaIdBlurImage: Types.MediaIdImage,
    @Serializable(with = MediaIdImageSer::class) override val mediaIdImage: Types.MediaIdImage,
    override val primaryColor: String,
    override val width: Long? = null
) : DtoMessagePayloadSeal, DtoMessagePayloadCamera
