// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol

open class StudioDetails : StudioBase() {
    var description: String? = null
    var label: String? = null
    var modules: StudioModuleSelection? = null
    lateinit var name: Symbol
}
