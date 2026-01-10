// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.AnyTime
import com.neome.api.meta.base.Types.EnumDefnDay

interface StudioBuildRepeatSettingWeeks : StudioBuildRepeatSetting {
    val setOfRepeatDay: List<EnumDefnDay>?
    val setOfTime: List<AnyTime>?
}
