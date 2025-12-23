// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdStep
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntAutomationStep

open class StudioEntAutomationStepMap : StudioBase()
{
  lateinit var keys: Array<MetaIdStep>
  lateinit var map: Map<MetaIdStep, StudioEntAutomationStep>
}