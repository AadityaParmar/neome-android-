// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnEventConditionMap
import com.neome.api.meta.base.Types.MetaIdFormEventCondition

interface DefnEventConditionHolder
{
  val map: Map<MetaIdFormEventCondition, DefnEventConditionMap>?
}