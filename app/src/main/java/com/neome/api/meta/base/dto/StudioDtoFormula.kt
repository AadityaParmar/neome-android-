// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdFormula
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioValueCodeJavascript
import com.neome.api.meta.base.dto.StudioValueVarIdCondition
import com.neome.api.meta.base.Symbol

interface StudioDtoFormula : StudioBase
{
  val assignToFieldId: MetaIdField
  val conditionVarId: StudioValueVarIdCondition?
  val formula: StudioValueCodeJavascript?
  val metaId: MetaIdFormula
  val name: Symbol?
}