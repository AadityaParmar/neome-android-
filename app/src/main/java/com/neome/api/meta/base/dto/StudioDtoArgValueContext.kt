// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnArgBinderContext
import com.neome.api.meta.base.dto.StudioDtoArgValue

open class StudioDtoArgValueContext : StudioDtoArgValue()
{
  lateinit var kind: EnumDefnArgBinderContext
}