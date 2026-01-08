// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdVisibilityCondition
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoVisibilityCondition

interface StudioMapOfVisibilityCondition : StudioBase
{
  val andOr: Boolean?
  val keys: Array<MetaIdVisibilityCondition>?
  val map: Map<MetaIdVisibilityCondition, StudioMapOfVisibilityCondition>?
  val metaId: MetaIdVisibilityCondition
  val statement: StudioDtoVisibilityCondition?
}