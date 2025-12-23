// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdModule
import java.util.Map

open class StudioModuleMap : StudioBase() {
    lateinit var keys: Array<MetaIdModule>
    lateinit var map: Map<MetaIdModule, StudioModule>
}
