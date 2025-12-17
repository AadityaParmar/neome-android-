// neome.ai API - do not change
//

package com.neome.api.ent.agent.msg;

import com.neome.api.meta.base.Types.EntId;
import com.neome.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgAgentActiveStatusUpdate extends Msg
{
  public boolean active;

  public EntId entId;
}