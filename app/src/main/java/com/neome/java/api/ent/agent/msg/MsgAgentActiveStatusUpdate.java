// neome.ai API - do not change
//

package com.neome.java.api.ent.agent.msg;

import com.neome.java.api.meta.base.Types.EntId;
import com.neome.java.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgAgentActiveStatusUpdate extends Msg
{
  public boolean active;

  public EntId entId;
}
