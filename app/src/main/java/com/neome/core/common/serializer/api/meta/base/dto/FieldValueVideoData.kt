package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FieldValueVideo
import com.neome.core.common.serializer.sysId.MediaIdImageSer
import com.neome.core.common.serializer.sysId.MediaIdVideoSer
import kotlinx.serialization.Serializable


@Serializable
data class FieldValueVideoData(
    override val durationMs: Long,
    override val fileName: String? = null,
    @Serializable(with = MediaIdImageSer::class) override val mediaIdBlurImage: Types.MediaIdImage,
    @Serializable(with = MediaIdImageSer::class) override val mediaIdImage: Types.MediaIdImage,
    @Serializable(with = MediaIdVideoSer::class) override val mediaIdVideo: Types.MediaIdVideo,
    override val primaryColor: String,
    override val size: Long
) : FieldValueVideo
