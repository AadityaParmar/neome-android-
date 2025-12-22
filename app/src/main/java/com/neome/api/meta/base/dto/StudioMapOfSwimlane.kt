// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdSwimlane

class StudioMapOfSwimlane : StudioBase() {
    var keys: MetaIdSwimlane[]? = null
    val map: Record<MetaIdSwimlane, StudioDtoSwimlane>
}
