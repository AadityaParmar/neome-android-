// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdHeader
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoTableHeader

interface StudioMapOfTableHeader : StudioBase
{
  val keys: Array<MetaIdHeader>
  val map: Map<MetaIdHeader, StudioDtoTableHeader>
}