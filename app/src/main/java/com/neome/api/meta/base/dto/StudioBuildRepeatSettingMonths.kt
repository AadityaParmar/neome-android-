// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.AnyTime
import com.neome.api.meta.base.Types.EnumDefnDateOccurrence

open class StudioBuildRepeatSettingMonths : StudioBuildRepeatSetting() {
    var customDateSet: Array<Number>? = null
    var dateOccurrence: EnumDefnDateOccurrence? = null
    var setOfTime: Array<AnyTime>? = null
}
