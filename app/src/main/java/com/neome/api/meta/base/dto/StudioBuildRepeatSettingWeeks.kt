// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.AnyTime
import com.neome.api.meta.base.Types.EnumDefnDay

class StudioBuildRepeatSettingWeeks : StudioBuildRepeatSetting() {
    var setOfRepeatDay: EnumDefnDay[]? = null
    var setOfTime: AnyTime[]? = null
}
