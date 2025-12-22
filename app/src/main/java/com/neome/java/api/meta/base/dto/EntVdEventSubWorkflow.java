// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdPipelineVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdEventSubWorkflow extends EntVdEvent
{
  @Nullable
  public FormRefKey inputForm;

  @Nullable
  public FormRefKey outputForm;

  @Nullable
  public MetaIdPipelineVar[] sharedParameterSet;

  @Nullable
  public EntVdWorkflowPointer workflowPointer;
}
