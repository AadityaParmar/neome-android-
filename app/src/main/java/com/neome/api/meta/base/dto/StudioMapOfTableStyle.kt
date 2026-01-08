// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdTableStyle
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoTableStyle

interface StudioMapOfTableStyle : StudioBase
{
  val keys: Array<MetaIdTableStyle>
  val map: Map<MetaIdTableStyle, StudioDtoTableStyle>
}