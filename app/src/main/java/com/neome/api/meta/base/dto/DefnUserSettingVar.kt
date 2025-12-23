// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnUserSettingOptions
import com.neome.api.meta.base.Types.MetaIdVar

open class DefnUserSettingVar {
    var description: String? = null
    lateinit var kind: EnumDefnUserSettingOptions
    var label: String? = null
    lateinit var name: Symbol
    var optionMap: DefnStudioMapOfDtoOption? = null
    lateinit var varId: MetaIdVar
}
