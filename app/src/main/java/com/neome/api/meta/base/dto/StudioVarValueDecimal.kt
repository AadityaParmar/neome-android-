// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import kotlin.properties.Delegates
import com.neome.api.meta.base.dto.StudioBase

open class StudioVarValueDecimal : StudioBase()
{
  var value: Number by Delegates.notNull<Number>()
}