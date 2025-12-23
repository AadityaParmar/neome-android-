// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnArgBinder

open class StudioBuildArgBinder : StudioBase() {
    lateinit var argName: String
    lateinit var kind: EnumDefnArgBinder
    lateinit var value: StudioDtoArgValue
}
