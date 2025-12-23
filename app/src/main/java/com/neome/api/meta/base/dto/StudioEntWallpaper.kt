// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MediaIdImage
import com.neome.api.meta.base.dto.StudioBase

open class StudioEntWallpaper : StudioBase()
{
  var repeatTile: Boolean? = null
  var wallpaperImageId: MediaIdImage? = null
}