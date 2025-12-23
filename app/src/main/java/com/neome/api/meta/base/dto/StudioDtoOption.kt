// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoColor

open class StudioDtoOption : StudioBase()
{
  var color: StudioDtoColor? = null
  var disabled: Boolean? = null
  lateinit var metaId: String
  lateinit var value: String
}