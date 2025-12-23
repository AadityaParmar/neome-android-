// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemeDirection

open class DefnStudioBuildColor : DefnField() {
    var allowShades: Boolean? = null
    var direction: EnumDefnThemeDirection? = null
}
