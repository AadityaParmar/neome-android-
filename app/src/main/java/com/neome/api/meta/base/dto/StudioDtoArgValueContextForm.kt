// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnArgBinderContextForm
import com.neome.api.meta.base.dto.StudioDtoArgValueContext

open class StudioDtoArgValueContextForm : StudioDtoArgValueContext()
{
  lateinit var attribute: EnumDefnArgBinderContextForm
}