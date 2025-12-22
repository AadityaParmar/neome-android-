// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.AnyTime
import com.neome.api.meta.base.Types.EnumDefnDateOccurrence
import com.neome.api.meta.base.Types.EnumDefnMonth

class StudioBuildRepeatSettingYears : StudioBuildRepeatSetting() {
    var customDateSet: number[]? = null
    var dateOccurrence: EnumDefnDateOccurrence? = null
    var setOfMonth: EnumDefnMonth[]? = null
    var setOfTime: AnyTime[]? = null
}
