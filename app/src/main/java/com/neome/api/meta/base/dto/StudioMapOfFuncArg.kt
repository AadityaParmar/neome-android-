// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdFuncArg
import java.util.Map

open class StudioMapOfFuncArg : StudioBase() {
    var keys: Array<MetaIdFuncArg>? = null
    lateinit var map: Map<MetaIdFuncArg, StudioDtoFuncArg>
}
