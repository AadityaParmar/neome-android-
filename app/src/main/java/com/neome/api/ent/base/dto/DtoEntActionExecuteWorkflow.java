// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import com.neome.api.meta.base.Types.MetaIdAutomation;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.dto.EntVdWorkflowPointer;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoEntActionExecuteWorkflow extends DtoEntAction
{
  @Nullable
  public MetaIdForm automationFormId;

  @Nullable
  public MetaIdAutomation automationId;

  @Nullable
  public EntVdWorkflowPointer workflowPointer;
}
