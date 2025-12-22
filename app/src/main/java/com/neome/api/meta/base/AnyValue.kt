// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base

// AnyValue base class placeholder

abstract class AnyValue {
    protected var value: String = ""

    fun getValue(): String = value

    override fun toString(): String = value
}
