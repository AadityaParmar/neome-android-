// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.TimeZoneKey

open class StudioVarValueScheduler {
    var repeatSetting: StudioBuildRepeatSetting? = null
    var startDateTime: String? = null
    var timeZone: TimeZoneKey? = null
}
