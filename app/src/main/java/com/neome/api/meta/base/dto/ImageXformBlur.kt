// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.ImageXform
import com.neome.api.meta.base.dto.StudioBuildArgBinder

open class ImageXformBlur : ImageXform()
{
  var value: StudioBuildArgBinder? = null
}