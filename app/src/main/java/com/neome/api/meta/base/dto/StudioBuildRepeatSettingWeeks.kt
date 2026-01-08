// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.AnyTime
import com.neome.api.meta.base.Types.EnumDefnDay
import com.neome.api.meta.base.dto.StudioBuildRepeatSetting

interface StudioBuildRepeatSettingWeeks : StudioBuildRepeatSetting
{
  val setOfRepeatDay: Array<EnumDefnDay>?
  val setOfTime: Array<AnyTime>?
}