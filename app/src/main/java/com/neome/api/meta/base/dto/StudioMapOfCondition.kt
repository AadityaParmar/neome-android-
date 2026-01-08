// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdCondition
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoConditionStatement

interface StudioMapOfCondition : StudioBase
{
  val andOr: Boolean?
  val keys: Array<MetaIdCondition>?
  val map: Map<MetaIdCondition, StudioMapOfCondition>?
  val metaId: MetaIdCondition
  val statement: StudioDtoConditionStatement?
}