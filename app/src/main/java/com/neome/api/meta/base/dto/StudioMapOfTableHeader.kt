// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdHeader
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoTableHeader

interface StudioMapOfTableHeader : StudioBase
{
  val keys: List<MetaIdHeader>
  val map: Map<MetaIdHeader, StudioDtoTableHeader>
}