// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioVar
import com.neome.api.meta.base.dto.StudioVarValueText

open class StudioVarText : StudioVar()
{
  var value: StudioVarValueText? = null
}