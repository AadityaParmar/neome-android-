// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

class StudioMapOfOption : StudioBase() {
    var addTextColor: boolean? = null
    val keys: string[]
    val map: Record<string, StudioDtoOption>
}
