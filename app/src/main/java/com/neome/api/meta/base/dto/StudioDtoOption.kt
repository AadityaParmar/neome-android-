// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

open class StudioDtoOption : StudioBase() {
    var color: StudioDtoColor? = null
    var disabled: Boolean? = null
    lateinit var metaId: String
    lateinit var value: String
}
