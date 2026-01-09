package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntWallpaper
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.MediaIdImageSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoEntWallpaperData(
    override val repeatTile: Boolean? = null,
    @Serializable(with = MediaIdImageSer::class) override val wallpaperImageId: Types.MediaIdImage? = null
) : DtoEntWallpaper
