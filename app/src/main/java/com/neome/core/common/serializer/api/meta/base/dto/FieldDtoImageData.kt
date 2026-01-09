package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FieldDtoImage
import com.neome.core.common.serializer.sysId.MediaIdImageSer
import kotlinx.serialization.Serializable


@Serializable
data class FieldDtoImageData(
    override val fileName: String,
    override val height: Long? = null,
    @Serializable(with = MediaIdImageSer::class) override val mediaIdBlurImage: Types.MediaIdImage,
    @Serializable(with = MediaIdImageSer::class) override val mediaIdImage: Types.MediaIdImage,
    override val primaryColor: String,
    override val size: Long? = null,
    override val width: Long? = null
) : FieldDtoImage
