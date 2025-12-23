// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.dto.StudioEntAutomationStep
import com.neome.api.meta.base.dto.StudioMapOfFormula

open class StudioEntAutomationStepCalculateFormulas : StudioEntAutomationStep()
{
  var formulaFormPipelineVarId: MetaIdPipelineParam? = null
  var newFormulaMap: StudioMapOfFormula? = null
  var recalculateFormFormulas: Boolean? = null
}