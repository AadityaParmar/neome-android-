// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdUserCondition
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoUserConditionStatement

interface StudioMapOfUserCondition : StudioBase
{
  val andOr: Boolean?
  val keys: List<MetaIdUserCondition>?
  val map: Map<MetaIdUserCondition, StudioMapOfUserCondition>?
  val metaId: MetaIdUserCondition
  val statement: StudioDtoUserConditionStatement?
}