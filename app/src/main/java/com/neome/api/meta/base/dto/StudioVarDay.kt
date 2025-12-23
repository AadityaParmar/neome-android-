// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnDay
import com.neome.api.meta.base.dto.StudioVar

open class StudioVarDay : StudioVar()
{
  var value: EnumDefnDay? = null
}