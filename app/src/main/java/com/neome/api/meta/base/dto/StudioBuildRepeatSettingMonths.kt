// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.AnyTime
import com.neome.api.meta.base.Types.EnumDefnDateOccurrence
import com.neome.api.meta.base.dto.StudioBuildRepeatSetting

interface StudioBuildRepeatSettingMonths : StudioBuildRepeatSetting
{
  val customDateSet: Array<Long>?
  val dateOccurrence: EnumDefnDateOccurrence?
  val setOfTime: Array<AnyTime>?
}