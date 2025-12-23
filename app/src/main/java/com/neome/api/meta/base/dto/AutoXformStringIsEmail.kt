// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.AutoXform
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter

open class AutoXformStringIsEmail : AutoXform()
{
  var outputField: StudioDtoArgValueParameter? = null
  var sourceField: StudioBuildArgBinder? = null
}