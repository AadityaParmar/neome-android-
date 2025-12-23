// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdFieldDynamicCondition
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoFieldDynamicCondition

open class StudioMapOfFieldDynamicCondition : StudioBase()
{
  var andOr: Boolean? = null
  var keys: Array<MetaIdFieldDynamicCondition>? = null
  var map: Map<MetaIdFieldDynamicCondition, StudioMapOfFieldDynamicCondition>? = null
  lateinit var metaId: MetaIdFieldDynamicCondition
  var statement: StudioDtoFieldDynamicCondition? = null
}