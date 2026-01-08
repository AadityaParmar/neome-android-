// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnTextValidationPattern
import com.neome.api.meta.base.dto.StudioBase

interface StudioDtoTextValidationPattern : StudioBase
{
  val customValue: String?
  val value: EnumDefnTextValidationPattern?
}