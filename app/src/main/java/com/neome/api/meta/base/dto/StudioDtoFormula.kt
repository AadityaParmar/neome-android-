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

open class StudioDtoFormula : StudioBase()
{
  lateinit var assignToFieldId: MetaIdField
  var conditionVarId: StudioValueVarIdCondition? = null
  var formula: StudioValueCodeJavascript? = null
  lateinit var metaId: MetaIdFormula
  var name: Symbol? = null
}