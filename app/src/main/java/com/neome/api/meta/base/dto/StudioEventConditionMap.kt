// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdFormEventCondition
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEventCondition
import com.neome.api.meta.base.Symbol

interface StudioEventConditionMap : StudioBase
{
  val andOr: Boolean?
  val keys: List<MetaIdFormEventCondition>?
  val map: Map<MetaIdFormEventCondition, StudioEventConditionMap>?
  val metaId: MetaIdFormEventCondition
  val name: Symbol
  val statement: StudioEventCondition?
}