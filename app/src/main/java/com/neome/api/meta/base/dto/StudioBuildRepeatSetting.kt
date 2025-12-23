// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Date
import com.neome.api.meta.base.Types.EnumDefnRepeatFrequencyKind
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBase

open class StudioBuildRepeatSetting : StudioBase()
{
  var endDateTime: String? = null
  var excludeSetOfDateVarId: MetaIdVar? = null
  var frequency: Number? = null
  lateinit var repeatFrequencyKind: EnumDefnRepeatFrequencyKind
}