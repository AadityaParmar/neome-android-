// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoOption

open class StudioMapOfOption : StudioBase()
{
  var addTextColor: Boolean? = null
  lateinit var keys: Array<String>
  lateinit var map: Map<String, StudioDtoOption>
}