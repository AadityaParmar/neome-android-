// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

interface DtoFieldFilterOption {
    val childFilters: List<DtoFieldFilterOption>?
    val label: String
    val value: String
}
