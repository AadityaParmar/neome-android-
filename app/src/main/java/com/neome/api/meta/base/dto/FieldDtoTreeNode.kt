// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

class FieldDtoTreeNode : StudioBase() {
    val keys: string[]
    val map: Record<string, FieldDtoTreeNode>
    val metaId: string
    var value: string? = null
}
