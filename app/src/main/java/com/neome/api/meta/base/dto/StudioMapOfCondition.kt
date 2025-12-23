// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdCondition
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoConditionStatement

open class StudioMapOfCondition : StudioBase()
{
  var andOr: Boolean? = null
  var keys: Array<MetaIdCondition>? = null
  var map: Map<MetaIdCondition, StudioMapOfCondition>? = null
  lateinit var metaId: MetaIdCondition
  var statement: StudioDtoConditionStatement? = null
}