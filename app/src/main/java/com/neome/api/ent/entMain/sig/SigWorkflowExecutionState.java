// neome.ai API - do not change
//

package com.neome.api.ent.entMain.sig;

import com.neome.api.ent.base.Types.EnumWorkflowResultKind;
import com.neome.api.ent.base.dto.DtoWorkflowParameterInfo;
import com.neome.api.ent.base.dto.WorkflowStepSummary;
import com.neome.api.meta.base.Types.MetaIdVdAutoNode;
import com.neome.api.meta.base.Types.WorkflowExecutionId;
import com.neome.api.meta.base.dto.EntVdWorkflowPointer;
import com.neome.api.nucleus.base.sig.SigVersion;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class SigWorkflowExecutionState extends SigVersion
{
  public Date createdOn;

  @Nullable
  public MetaIdVdAutoNode currNodeId;

  public EnumWorkflowResultKind currStateKind;

  public WorkflowExecutionId executionId;

  @Nullable
  public MetaIdVdAutoNode[] executionPathList;

  @Nullable
  public DtoWorkflowParameterInfo[] parameters;

  @Nullable
  public WorkflowStepSummary[] summaryList;

  public Date updatedOn;

  public EntVdWorkflowPointer workflowPointer;
}
