// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdFieldDynamicCondition
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoFieldDynamicCondition

interface StudioMapOfFieldDynamicCondition : StudioBase
{
  val andOr: Boolean?
  val keys: Array<MetaIdFieldDynamicCondition>?
  val map: Map<MetaIdFieldDynamicCondition, StudioMapOfFieldDynamicCondition>?
  val metaId: MetaIdFieldDynamicCondition
  val statement: StudioDtoFieldDynamicCondition?
}