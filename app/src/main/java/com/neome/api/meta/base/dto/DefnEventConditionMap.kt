// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnEventCondition
import com.neome.api.meta.base.Types.MetaIdFormEventCondition

interface DefnEventConditionMap
{
  val andOr: Boolean?
  val keys: List<MetaIdFormEventCondition>?
  val map: Map<MetaIdFormEventCondition, DefnEventConditionMap>?
  val metaId: MetaIdFormEventCondition
  val statement: DefnEventCondition?
}