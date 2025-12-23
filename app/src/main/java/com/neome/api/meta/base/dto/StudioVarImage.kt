// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioVar
import com.neome.api.meta.base.dto.StudioVarValueImage

open class StudioVarImage : StudioVar()
{
  var value: StudioVarValueImage? = null
}