// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdPipelineParam;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationStepRemoveSpreadsheetRows extends StudioEntAutomationStep
{
  @Nullable
  public StudioValueVarIdCondition conditionVarId;

  @Nullable
  public MetaIdPipelineParam inputFormPipelineVarId;

  @Nullable
  public MetaIdSpreadsheet targetSpreadsheetId;
}
