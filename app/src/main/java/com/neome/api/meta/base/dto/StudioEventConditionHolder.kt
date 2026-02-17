// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdFormEventCondition
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEventConditionMap

interface StudioEventConditionHolder : StudioBase
{
  val map: Map<MetaIdFormEventCondition, StudioEventConditionMap>?
}