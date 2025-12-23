// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map

open class FieldDtoTree {
    lateinit var keys: Array<String>
    lateinit var map: Map<String, FieldDtoTreeNode>
}
