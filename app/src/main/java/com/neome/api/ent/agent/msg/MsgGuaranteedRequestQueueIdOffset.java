// neome.ai API - do not change
//

package com.neome.api.ent.agent.msg;

import com.neome.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgGuaranteedRequestQueueIdOffset extends Msg
{
  public long offset;

  public String queueId;
}