// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnArgBinder
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoArgValue

interface StudioBuildArgBinder : StudioBase
{
  val argName: String
  val kind: EnumDefnArgBinder
  val value: StudioDtoArgValue
}