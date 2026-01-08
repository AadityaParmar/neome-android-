// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindImageXform
import com.neome.api.meta.base.dto.StudioBase

interface ImageXform : StudioBase
{
  val kind: EnumDefnKindImageXform?
}