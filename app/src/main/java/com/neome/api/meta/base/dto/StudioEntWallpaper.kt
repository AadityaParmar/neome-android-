// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MediaIdImage
import com.neome.api.meta.base.dto.StudioBase

interface StudioEntWallpaper : StudioBase
{
  val repeatTile: Boolean?
  val wallpaperImageId: MediaIdImage?
}