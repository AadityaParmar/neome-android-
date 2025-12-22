// neome.ai API - do not change
//

package com.neome.java.api.ent.entMain.msg;

import com.neome.java.api.meta.base.Types.GroupId;
import com.neome.java.api.meta.base.Types.MetaIdAction;
import com.neome.java.api.meta.base.Types.MetaIdForm;
import com.neome.java.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgSpreadsheetPartitionSend extends Msg
{
  public MetaIdAction actionId;

  public MetaIdForm formId;

  public GroupId toGroupId;
}
