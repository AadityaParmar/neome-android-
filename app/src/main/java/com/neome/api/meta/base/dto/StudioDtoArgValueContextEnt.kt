// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnArgBinderContextEnt
import com.neome.api.meta.base.dto.StudioDtoArgValueContext

open class StudioDtoArgValueContextEnt : StudioDtoArgValueContext()
{
  lateinit var attribute: EnumDefnArgBinderContextEnt
}