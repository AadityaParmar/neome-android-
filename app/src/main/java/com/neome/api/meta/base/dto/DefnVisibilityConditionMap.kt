// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnVisibilityCondition
import com.neome.api.meta.base.Types.MetaIdVisibilityCondition

interface DefnVisibilityConditionMap
{
  val andOr: Boolean?
  val keys: List<MetaIdVisibilityCondition>?
  val map: Map<MetaIdVisibilityCondition, DefnVisibilityConditionMap>?
  val metaId: MetaIdVisibilityCondition
  val statement: DefnVisibilityCondition?
}