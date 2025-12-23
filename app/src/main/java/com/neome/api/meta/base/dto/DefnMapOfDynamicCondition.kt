// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoDynamicCondition
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdFieldDynamicCondition

open class DefnMapOfDynamicCondition
{
  var andOr: Boolean? = null
  var keys: Array<MetaIdFieldDynamicCondition>? = null
  var map: Map<MetaIdFieldDynamicCondition, DefnMapOfDynamicCondition>? = null
  lateinit var metaId: MetaIdFieldDynamicCondition
  var statement: DefnDtoDynamicCondition? = null
}