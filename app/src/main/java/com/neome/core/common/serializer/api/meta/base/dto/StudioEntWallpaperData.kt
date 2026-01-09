package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntWallpaper
import com.neome.core.common.serializer.sysId.MediaIdImageSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntWallpaperData(
    override val repeatTile: Boolean? = null,
    @Serializable(with = MediaIdImageSer::class) override val wallpaperImageId: Types.MediaIdImage? = null
) : StudioEntWallpaper
