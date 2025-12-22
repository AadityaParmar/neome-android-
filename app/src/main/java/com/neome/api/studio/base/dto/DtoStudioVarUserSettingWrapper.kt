// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnUserSettingOptions
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.DefnStudioMapOfDtoOption

class DtoStudioVarUserSettingWrapper {
    var description: string? = null
    val kind: EnumDefnUserSettingOptions
    var label: string? = null
    val name: Symbol
    var optionMap: DefnStudioMapOfDtoOption? = null
    val varId: MetaIdVar
}
