// neome.ai API - do not change
//

package com.neome.api.ent.entMain.msg;

import com.neome.api.meta.base.Types.MetaIdAutomation;
import com.neome.api.meta.base.dto.EntVdWorkflowPointer;
import com.neome.api.meta.base.dto.FormValueRaw;
import com.neome.api.nucleus.base.msg.Msg;

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
