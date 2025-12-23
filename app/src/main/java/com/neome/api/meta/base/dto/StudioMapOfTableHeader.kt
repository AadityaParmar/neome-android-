// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdHeader
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoTableHeader

open class StudioMapOfTableHeader : StudioBase()
{
  lateinit var keys: Array<MetaIdHeader>
  lateinit var map: Map<MetaIdHeader, StudioDtoTableHeader>
}