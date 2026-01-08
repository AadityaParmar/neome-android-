// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemeStroke
import com.neome.api.meta.base.dto.StudioVar

interface StudioVarStroke : StudioVar
{
  val value: EnumDefnThemeStroke?
}