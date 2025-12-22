// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdAutomation;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntActionExecuteWorkflow extends StudioEntAction
{
  @Nullable
  public MetaIdAutomation automationId;

  @Nullable
  public EntVdWorkflowPointer workflowPointer;
}
