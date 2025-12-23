// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnDate

open class StudioBuildDate : StudioBase() {
    var customValue: String? = null
    var value: EnumDefnDate? = null
}
