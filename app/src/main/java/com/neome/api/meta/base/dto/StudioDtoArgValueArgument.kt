// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnArgBinderArgument
import com.neome.api.meta.base.Types.MetaIdField

open class StudioDtoArgValueArgument : StudioDtoArgValue() {
    lateinit var arg1: EnumDefnArgBinderArgument
    var arg2: EnumDefnArgBinderArgument? = null
    lateinit var fieldId: MetaIdField
    var valuePathArray: Array<String>? = null
}
