// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoConditionStatement
import com.neome.api.meta.base.Types.MetaIdCondition

interface DefnMapOfCondition
{
  val andOr: Boolean?
  val keys: Array<MetaIdCondition>?
  val map: Map<MetaIdCondition, DefnMapOfCondition>?
  val metaId: MetaIdCondition
  val statement: DefnDtoConditionStatement?
}