package com.neome.core.common.serializer.api

import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.MediaIdImageSer
import kotlinx.serialization.Serializable

interface DtoMessagePayloadImage : DtoMessagePayloadText {
    var fileSize: Long?
    var height: Long?

    @Serializable(with = MediaIdImageSer::class)
    var mediaIdBlurImage: Types.MediaIdImage

    @Serializable(with = MediaIdImageSer::class)
    var mediaIdImage: Types.MediaIdImage
    var primaryColor: String
    var width: Long?
}
