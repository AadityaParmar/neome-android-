// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdVisibilityCondition
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoVisibilityCondition

open class StudioMapOfVisibilityCondition : StudioBase()
{
  var andOr: Boolean? = null
  var keys: Array<MetaIdVisibilityCondition>? = null
  var map: Map<MetaIdVisibilityCondition, StudioMapOfVisibilityCondition>? = null
  lateinit var metaId: MetaIdVisibilityCondition
  var statement: StudioDtoVisibilityCondition? = null
}