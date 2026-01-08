// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoDynamicCondition
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdFieldDynamicCondition

interface DefnMapOfDynamicCondition
{
  val andOr: Boolean?
  val keys: Array<MetaIdFieldDynamicCondition>?
  val map: Map<MetaIdFieldDynamicCondition, DefnMapOfDynamicCondition>?
  val metaId: MetaIdFieldDynamicCondition
  val statement: DefnDtoDynamicCondition?
}