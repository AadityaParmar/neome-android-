// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import com.neome.api.ent.base.Types.EnumWorkflowResultKind;
import com.neome.api.meta.base.Types.EnumDefnKindAutoNode;
import com.neome.api.meta.base.Types.WorkflowExecutionId;
import com.neome.api.meta.base.dto.DefnStudioMapOfDtoOption;
import com.neome.api.meta.base.dto.EnvValidationError;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class DtoWorkflowExecutionStateInfo
{
  public String callerName;

  @Nullable
  public Boolean canAdminResume;

  @Nullable
  public Date createdOn;

  public EnumDefnKindAutoNode eventKind;

  public WorkflowExecutionId executionId;

  @Nullable
  public EnvValidationError failureError;

  @Nullable
  public String message;

  public String name;

  public String nodeName;

  @Nullable
  public DefnStudioMapOfDtoOption resumeOptions;

  public EnumWorkflowResultKind stateKind;

  @Nullable
  public Date updatedOn;
}
