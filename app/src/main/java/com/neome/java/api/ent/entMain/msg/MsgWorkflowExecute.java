// neome.ai API - do not change
//

package com.neome.java.api.ent.entMain.msg;

import com.neome.java.api.meta.base.Types.MetaIdAutomation;
import com.neome.java.api.meta.base.dto.EntVdWorkflowPointer;
import com.neome.java.api.meta.base.dto.FormValueRaw;
import com.neome.java.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgWorkflowExecute extends Msg
{
  @Nullable
  public MetaIdAutomation automationId;

  public FormValueRaw formValue;

  @Nullable
  public EntVdWorkflowPointer workflowPointer;
}
