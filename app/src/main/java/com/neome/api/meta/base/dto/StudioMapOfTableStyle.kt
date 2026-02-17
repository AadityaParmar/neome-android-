// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdTableStyle
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoTableStyle

interface StudioMapOfTableStyle : StudioBase
{
  val keys: List<MetaIdTableStyle>
  val map: Map<MetaIdTableStyle, StudioDtoTableStyle>
}