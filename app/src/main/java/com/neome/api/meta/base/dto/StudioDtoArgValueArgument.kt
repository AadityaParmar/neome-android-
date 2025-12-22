// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnArgBinderArgument
import com.neome.api.meta.base.Types.MetaIdField

class StudioDtoArgValueArgument : StudioDtoArgValue() {
    val arg1: EnumDefnArgBinderArgument
    var arg2: EnumDefnArgBinderArgument? = null
    val fieldId: MetaIdField
    var valuePathArray: string[]? = null
}
