// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdModule

interface StudioModuleMap : StudioBase {
    val keys: List<MetaIdModule>
    val map: Map<MetaIdModule, StudioModule>
}
