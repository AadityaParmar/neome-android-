// neome.ai API - do not change
//

package com.neome.java.api.ent.entMain.msg;

import com.neome.java.api.meta.base.Types.MetaIdPipelineParam;
import com.neome.java.api.meta.base.Types.MetaIdVdAutoNode;
import com.neome.java.api.meta.base.Types.WorkflowExecutionId;
import com.neome.java.api.meta.base.dto.FormValueRaw;
import com.neome.java.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgWorkflowExecutionParamUpdate extends Msg
{
  public MetaIdVdAutoNode branchNodeId;

  public WorkflowExecutionId executionId;

  public FormValueRaw formValue;

  public MetaIdPipelineParam paramId;
}
