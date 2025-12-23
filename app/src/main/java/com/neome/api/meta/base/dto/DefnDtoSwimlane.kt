// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdSwimlane

open class DefnDtoSwimlane {
    var color: DefnDtoColor? = null
    var colorVar: DefnDtoColor? = null
    var label: String? = null
    lateinit var metaId: MetaIdSwimlane
    var valueOptionId: String? = null
}
