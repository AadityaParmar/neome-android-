// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnUserSettingOptions
import com.neome.api.meta.base.Types.MetaIdVar

class DefnUserSettingVar {
    var description: string? = null
    val kind: EnumDefnUserSettingOptions
    var label: string? = null
    val name: Symbol
    var optionMap: DefnStudioMapOfDtoOption? = null
    val varId: MetaIdVar
}
