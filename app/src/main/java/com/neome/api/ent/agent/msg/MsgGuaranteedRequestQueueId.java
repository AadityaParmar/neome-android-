// neome.ai API - do not change
//

package com.neome.api.ent.agent.msg;

import com.neome.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgGuaranteedRequestQueueId extends Msg
{
  public long pageSize;

  public String queueId;

  @Nullable
  public Long startOffset;
}
