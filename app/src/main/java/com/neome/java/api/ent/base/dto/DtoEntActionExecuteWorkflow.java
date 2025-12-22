// neome.ai API - do not change
//

package com.neome.java.api.ent.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdAutomation;
import com.neome.java.api.meta.base.Types.MetaIdForm;
import com.neome.java.api.meta.base.dto.EntVdWorkflowPointer;

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
