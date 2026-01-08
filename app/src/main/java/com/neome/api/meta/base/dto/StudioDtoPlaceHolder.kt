// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldDtoImage
import com.neome.api.meta.base.dto.StudioBase

interface StudioDtoPlaceHolder : StudioBase
{
  val image: FieldDtoImage?
  val primaryText: String?
  val secondaryText: String?
}