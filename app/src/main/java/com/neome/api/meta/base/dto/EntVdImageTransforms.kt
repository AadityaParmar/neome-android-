// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStep
import com.neome.api.meta.base.dto.ImageXform
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdVdImageFunc
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter

open class EntVdImageTransforms : EntVdAutoStep()
{
  var inputField: StudioDtoArgValueParameter? = null
  lateinit var keys: Array<MetaIdVdImageFunc>
  lateinit var map: Map<MetaIdVdImageFunc, ImageXform>
  var outputField: StudioDtoArgValueParameter? = null
}