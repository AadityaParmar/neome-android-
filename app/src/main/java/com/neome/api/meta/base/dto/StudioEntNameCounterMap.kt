// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindAutoNode
import java.util.Map

open class StudioEntNameCounterMap : StudioBase() {
    lateinit var vdAutoNameGenMap: Map<EnumDefnKindAutoNode, Number>
}
