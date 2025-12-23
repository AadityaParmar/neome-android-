// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

open class DefnDtoOption {
    var color: DefnDtoColor? = null
    var disabled: Boolean? = null
    var hint: String? = null
    var isRemoved: Boolean? = null
    lateinit var metaId: String
    lateinit var value: String
}
