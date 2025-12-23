// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.AutoXform
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter
import com.neome.api.meta.base.dto.StudioMapOfArgBinder

open class AutoXformStringJoiner : AutoXform()
{
  var outputField: StudioDtoArgValueParameter? = null
  var separator: StudioBuildArgBinder? = null
  var sourceFieldMap: StudioMapOfArgBinder? = null
}