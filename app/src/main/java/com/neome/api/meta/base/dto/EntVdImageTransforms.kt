// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStep
import com.neome.api.meta.base.dto.ImageXform
import com.neome.api.meta.base.Types.MetaIdVdImageFunc
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter

interface EntVdImageTransforms : EntVdAutoStep
{
  val inputField: StudioDtoArgValueParameter?
  val keys: List<MetaIdVdImageFunc>
  val map: Map<MetaIdVdImageFunc, ImageXform>
  val outputField: StudioDtoArgValueParameter?
}