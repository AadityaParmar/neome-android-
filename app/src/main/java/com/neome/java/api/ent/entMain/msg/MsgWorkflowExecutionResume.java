// neome.ai API - do not change
//

package com.neome.java.api.ent.entMain.msg;

import com.neome.java.api.ent.base.Types.EnumWorkflowDebugActionKind;
import com.neome.java.api.meta.base.Types.WorkflowExecutionId;
import com.neome.java.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgWorkflowExecutionResume extends Msg
{
  @Nullable
  public EnumWorkflowDebugActionKind debugAction;

  public WorkflowExecutionId executionId;

  @Nullable
  public String userOption;
}
