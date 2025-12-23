// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdSwimlane
import java.util.Map

open class StudioMapOfSwimlane : StudioBase() {
    var keys: Array<MetaIdSwimlane>? = null
    lateinit var map: Map<MetaIdSwimlane, StudioDtoSwimlane>
}
