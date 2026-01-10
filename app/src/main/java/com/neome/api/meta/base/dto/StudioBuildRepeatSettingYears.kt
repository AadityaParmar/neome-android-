// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.AnyTime
import com.neome.api.meta.base.Types.EnumDefnDateOccurrence
import com.neome.api.meta.base.Types.EnumDefnMonth

interface StudioBuildRepeatSettingYears : StudioBuildRepeatSetting {
    val customDateSet: List<Long>?
    val dateOccurrence: EnumDefnDateOccurrence?
    val setOfMonth: List<EnumDefnMonth>?
    val setOfTime: List<AnyTime>?
}
