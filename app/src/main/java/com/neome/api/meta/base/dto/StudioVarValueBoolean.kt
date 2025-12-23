// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import kotlin.properties.Delegates

open class StudioVarValueBoolean : StudioBase() {
    var value: Boolean by Delegates.notNull<Boolean>()
}
