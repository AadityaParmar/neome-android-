// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdStep
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntAutomationStep

interface StudioEntAutomationStepMap : StudioBase
{
  val keys: Array<MetaIdStep>
  val map: Map<MetaIdStep, StudioEntAutomationStep>
}