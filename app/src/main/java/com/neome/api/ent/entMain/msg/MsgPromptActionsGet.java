// neome.ai API - do not change
//

package com.neome.api.ent.entMain.msg;

import com.neome.api.meta.base.Types.GroupId;
import com.neome.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgPromptActionsGet extends Msg
{
  public GroupId groupId;

  public String promptText;
}