// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdSwimlane

class DefnDtoSwimlane {
    var color: DefnDtoColor? = null
    var colorVar: DefnDtoColor? = null
    var label: string? = null
    val metaId: MetaIdSwimlane
    var valueOptionId: string? = null
}
