// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnArgBinderContextCaller

open class StudioDtoArgValueContextCaller : StudioDtoArgValueContext() {
    lateinit var attribute: EnumDefnArgBinderContextCaller
}
