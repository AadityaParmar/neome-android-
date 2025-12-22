// neome.ai API - do not change
//

package com.neome.java.api.home.main.msg;

import com.neome.java.api.core.base.dto.DtoChatMessageOffset;
import com.neome.java.api.home.base.dto.DtoMessagePayload;
import com.neome.java.api.home.base.dto.DtoMessageReplyPayload;
import com.neome.java.api.meta.base.Types.ChatId;
import com.neome.java.api.meta.base.Types.MessageId;
import com.neome.java.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgMessageSend extends Msg
{
  public ChatId chatId;

  @Nullable
  public DtoChatMessageOffset chatMessageOffset;

  public MessageId messageId;

  public DtoMessagePayload payload;

  @Nullable
  public DtoMessageReplyPayload replyPayload;
}
