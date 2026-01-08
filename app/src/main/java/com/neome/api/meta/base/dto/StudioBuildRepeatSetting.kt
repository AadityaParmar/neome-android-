// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Date
import com.neome.api.meta.base.Types.EnumDefnRepeatFrequencyKind
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBase

interface StudioBuildRepeatSetting : StudioBase
{
  val endDateTime: String?
  val excludeSetOfDateVarId: MetaIdVar?
  val frequency: Long?
  val repeatFrequencyKind: EnumDefnRepeatFrequencyKind
}