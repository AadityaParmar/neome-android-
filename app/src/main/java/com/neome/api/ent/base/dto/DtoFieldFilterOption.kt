// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

open class DtoFieldFilterOption {
    var childFilters: Array<DtoFieldFilterOption>? = null
    lateinit var label: String
    lateinit var value: String
}
