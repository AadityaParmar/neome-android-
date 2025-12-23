// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBuildTime
import com.neome.api.meta.base.dto.StudioVar

open class StudioVarTime : StudioVar()
{
  var value: StudioBuildTime? = null
}