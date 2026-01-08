// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoTableStyle
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdTableStyle

interface DefnMapOfTableStyle
{
  val keys: Array<MetaIdTableStyle>?
  val map: Map<MetaIdTableStyle, DefnDtoTableStyle>
}