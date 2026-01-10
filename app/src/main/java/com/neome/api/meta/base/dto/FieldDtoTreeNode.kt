// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

interface FieldDtoTreeNode : StudioBase {
    val keys: List<String>
    val map: Map<String, FieldDtoTreeNode>
    val metaId: String
    val value: String?
}
