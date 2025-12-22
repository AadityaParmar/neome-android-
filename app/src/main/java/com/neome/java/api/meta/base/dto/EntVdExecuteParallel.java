// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnKindAutoResponseWait;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdExecuteParallel extends EntVdAutoStepWithError
{
  @Nullable
  public EnumDefnKindAutoResponseWait responseWaitKind;

  @Nullable
  public EntVdWorkflowControlMap workflowControlMap;
}
