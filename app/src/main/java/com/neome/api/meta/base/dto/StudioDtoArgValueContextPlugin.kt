// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnArgBinderContextPlugin
import com.neome.api.meta.base.dto.StudioDtoArgValueContext

interface StudioDtoArgValueContextPlugin : StudioDtoArgValueContext
{
  val attribute: EnumDefnArgBinderContextPlugin
}