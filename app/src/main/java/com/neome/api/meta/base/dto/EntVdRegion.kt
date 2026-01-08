// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdRect
import com.neome.api.meta.base.Types.MetaIdVdRegion

interface EntVdRegion : EntVdRect
{
  val metaId: MetaIdVdRegion
}