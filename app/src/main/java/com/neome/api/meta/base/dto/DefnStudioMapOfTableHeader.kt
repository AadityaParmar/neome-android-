// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoTableHeader
import com.neome.api.meta.base.Types.MetaIdHeader

interface DefnStudioMapOfTableHeader
{
  val keys: Array<MetaIdHeader>
  val map: Map<MetaIdHeader, DefnDtoTableHeader>
}