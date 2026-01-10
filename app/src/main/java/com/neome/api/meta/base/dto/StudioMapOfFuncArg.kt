// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdFuncArg

interface StudioMapOfFuncArg : StudioBase {
    val keys: List<MetaIdFuncArg>?
    val map: Map<MetaIdFuncArg, StudioDtoFuncArg>
}
