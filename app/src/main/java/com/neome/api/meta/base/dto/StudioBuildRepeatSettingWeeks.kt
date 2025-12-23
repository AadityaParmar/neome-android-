// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.AnyTime
import com.neome.api.meta.base.Types.EnumDefnDay
import com.neome.api.meta.base.dto.StudioBuildRepeatSetting

open class StudioBuildRepeatSettingWeeks : StudioBuildRepeatSetting()
{
  var setOfRepeatDay: Array<EnumDefnDay>? = null
  var setOfTime: Array<AnyTime>? = null
}