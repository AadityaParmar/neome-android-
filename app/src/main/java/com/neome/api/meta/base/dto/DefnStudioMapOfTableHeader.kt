// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoTableHeader
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdHeader

open class DefnStudioMapOfTableHeader
{
  lateinit var keys: Array<MetaIdHeader>
  lateinit var map: Map<MetaIdHeader, DefnDtoTableHeader>
}