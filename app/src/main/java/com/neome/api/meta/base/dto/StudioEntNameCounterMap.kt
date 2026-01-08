// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindAutoNode
import com.neome.api.meta.base.dto.StudioBase

interface StudioEntNameCounterMap : StudioBase
{
  val vdAutoNameGenMap: Map<EnumDefnKindAutoNode, Number>
}