// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnRepeatFrequencyKind
import com.neome.api.meta.base.Types.MetaIdVar

class StudioBuildRepeatSetting : StudioBase() {
    var endDateTime: string? = null
    var excludeSetOfDateVarId: MetaIdVar? = null
    var frequency: number? = null
    val repeatFrequencyKind: EnumDefnRepeatFrequencyKind
}
