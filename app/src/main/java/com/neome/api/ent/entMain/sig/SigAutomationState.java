// neome.ai API - do not change
//

package com.neome.api.ent.entMain.sig;

import com.neome.api.ent.base.dto.AutomationStepSummary;
import com.neome.api.ent.base.dto.DtoAutomationVariableInfo;
import com.neome.api.meta.base.Types.AutomationExecutionId;
import com.neome.api.nucleus.base.sig.Sig;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class SigAutomationState extends Sig
{
  public AutomationExecutionId executionId;

  @Nullable
  public AutomationStepSummary[] summaryList;

  @Nullable
  public DtoAutomationVariableInfo[] variables;
}
