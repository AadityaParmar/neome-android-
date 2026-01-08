// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoColor

interface StudioDtoOption : StudioBase
{
  val color: StudioDtoColor?
  val disabled: Boolean?
  val metaId: String
  val value: String
}