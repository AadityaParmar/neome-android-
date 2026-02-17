// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdFormEventAction
import com.neome.api.meta.base.Types.MetaIdFormEventActionBinding
import com.neome.api.meta.base.Types.MetaIdFormEventCondition
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.Symbol

interface StudioEventActionBinding : StudioBase
{
  val actionId: MetaIdFormEventAction
  val conditionId: MetaIdFormEventCondition?
  val metaId: MetaIdFormEventActionBinding
  val name: Symbol
  val notCondition: Boolean?
}