// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdVar

open class StudioDtoArgValueVariable : StudioDtoArgValue() {
    var valuePathArray: Array<String>? = null
    lateinit var varId: MetaIdVar
}
