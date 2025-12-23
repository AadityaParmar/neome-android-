// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoConditionStatement
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdCondition

open class DefnMapOfCondition
{
  var andOr: Boolean? = null
  var keys: Array<MetaIdCondition>? = null
  var map: Map<MetaIdCondition, DefnMapOfCondition>? = null
  lateinit var metaId: MetaIdCondition
  var statement: DefnDtoConditionStatement? = null
}