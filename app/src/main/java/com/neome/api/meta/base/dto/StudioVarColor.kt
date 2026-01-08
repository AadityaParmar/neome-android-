// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.api.meta.base.dto.StudioVar

interface StudioVarColor : StudioVar
{
  val value: StudioDtoColor?
}