// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

class StudioDtoOption : StudioBase() {
    var color: StudioDtoColor? = null
    var disabled: boolean? = null
    val metaId: string
    val value: string
}
