// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import kotlin.properties.Delegates

open class StudioVarValueNumber {
    var value: Number by Delegates.notNull<Number>()
}
