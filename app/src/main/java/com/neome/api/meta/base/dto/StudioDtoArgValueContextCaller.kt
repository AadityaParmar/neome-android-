// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnArgBinderContextCaller
import com.neome.api.meta.base.dto.StudioDtoArgValueContext

interface StudioDtoArgValueContextCaller : StudioDtoArgValueContext
{
  val attribute: EnumDefnArgBinderContextCaller
}