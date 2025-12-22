// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdPipelineParam;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationStepCalculateFormulas extends StudioEntAutomationStep
{
  @Nullable
  public MetaIdPipelineParam formulaFormPipelineVarId;

  @Nullable
  public StudioMapOfFormula newFormulaMap;

  @Nullable
  public Boolean recalculateFormFormulas;
}
