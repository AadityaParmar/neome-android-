// neome.ai API - do not change
//

package com.neome.java.api.ent.entMain.sig;

import com.neome.java.api.ent.base.dto.AutomationStepSummary;
import com.neome.java.api.ent.base.dto.DtoAutomationVariableInfo;
import com.neome.java.api.meta.base.Types.AutomationExecutionId;
import com.neome.java.api.nucleus.base.sig.Sig;

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
