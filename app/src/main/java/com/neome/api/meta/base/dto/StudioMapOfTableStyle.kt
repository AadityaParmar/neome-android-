// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdTableStyle
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoTableStyle

open class StudioMapOfTableStyle : StudioBase()
{
  lateinit var keys: Array<MetaIdTableStyle>
  lateinit var map: Map<MetaIdTableStyle, StudioDtoTableStyle>
}