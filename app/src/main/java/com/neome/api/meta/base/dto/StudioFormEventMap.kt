// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdFormEvent
import com.neome.api.meta.base.dto.StudioActionHolder
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEventConditionHolder
import com.neome.api.meta.base.dto.StudioFormEvent

interface StudioFormEventMap : StudioBase
{
  val actions: StudioActionHolder?
  val conditions: StudioEventConditionHolder?
  val keys: List<MetaIdFormEvent>
  val map: Map<MetaIdFormEvent, StudioFormEvent>
}