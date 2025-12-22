// neome.ai API - do not change
//

package com.neome.java.api.ent.agent.msg;

import com.neome.java.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgGuaranteedRequestQueueId extends Msg
{
  public long pageSize;

  public String queueId;

  @Nullable
  public Long startOffset;
}
