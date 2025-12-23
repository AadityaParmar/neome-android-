// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.MetaIdSwimlane
import com.neome.api.meta.base.Types.MetaIdVar

open class StudioDtoSwimlane : StudioBase() {
    var color: StudioDtoColor? = null
    var colorVarId: MetaIdVar? = null
    var label: String? = null
    lateinit var metaId: MetaIdSwimlane
    var name: Symbol? = null
    var valueOptionId: String? = null
}
