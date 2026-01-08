// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemeImageCorner
import com.neome.api.meta.base.dto.StudioVar

interface StudioVarImageCorner : StudioVar
{
  val value: EnumDefnThemeImageCorner?
}