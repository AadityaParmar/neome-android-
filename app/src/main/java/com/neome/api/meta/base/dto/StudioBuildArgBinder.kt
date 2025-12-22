// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnArgBinder

class StudioBuildArgBinder : StudioBase() {
    val argName: string
    val kind: EnumDefnArgBinder
    val value: StudioDtoArgValue
}
