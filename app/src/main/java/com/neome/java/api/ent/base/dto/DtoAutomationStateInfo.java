// neome.ai API - do not change
//

package com.neome.java.api.ent.base.dto;

import com.neome.java.api.ent.base.Types.EnumAutomationStateKind;
import com.neome.java.api.meta.base.Types.AutomationExecutionId;
import com.neome.java.api.meta.base.Types.EnumDefnKindAutomation;
import com.neome.java.api.meta.base.dto.EnvValidationError;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class DtoAutomationStateInfo
{
  public String callerName;

  @Nullable
  public Date createdOn;

  public String eventName;

  public AutomationExecutionId executionId;

  @Nullable
  public EnvValidationError failureError;

  public EnumDefnKindAutomation kind;

  @Nullable
  public String message;

  public String name;

  public EnumAutomationStateKind stateKind;

  public String stepName;

  @Nullable
  public Date updatedOn;
}
