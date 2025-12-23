// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoOption
import java.util.Map

open class DefnStudioMapOfDtoOption
{
  lateinit var keys: Array<String>
  lateinit var map: Map<String, DefnDtoOption>
}