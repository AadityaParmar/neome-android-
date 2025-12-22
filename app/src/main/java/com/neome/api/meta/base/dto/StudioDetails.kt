// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol

class StudioDetails : StudioBase() {
    var description: string? = null
    var label: string? = null
    var modules: StudioModuleSelection? = null
    val name: Symbol
}
