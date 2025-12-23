// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBuildDate
import com.neome.api.meta.base.dto.StudioVar

open class StudioVarDate : StudioVar()
{
  var value: StudioBuildDate? = null
}