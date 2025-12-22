// neome.ai API - do not change
//

package com.neome.java.api.home.main.msg;

import com.neome.java.api.meta.base.Types.MessageId;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgMessageListJump extends MsgMessageList
{
  @Nullable
  public MessageId messageId;

  @Nullable
  public Long offset;
}
