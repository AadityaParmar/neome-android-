// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.AnyTime
import com.neome.api.meta.base.Types.EnumDefnDateOccurrence

class StudioBuildRepeatSettingMonths : StudioBuildRepeatSetting() {
    var customDateSet: number[]? = null
    var dateOccurrence: EnumDefnDateOccurrence? = null
    var setOfTime: AnyTime[]? = null
}
