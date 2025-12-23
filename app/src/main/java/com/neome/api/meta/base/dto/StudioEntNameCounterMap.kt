// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindAutoNode
import java.util.Map
import com.neome.api.meta.base.dto.StudioBase

open class StudioEntNameCounterMap : StudioBase()
{
  lateinit var vdAutoNameGenMap: Map<EnumDefnKindAutoNode, Number>
}