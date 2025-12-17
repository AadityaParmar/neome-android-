// neome.ai API - do not change
//

package com.neome.api.home.main.msg;

import com.neome.api.meta.base.Types.ChatId;
import com.neome.api.meta.base.Types.EntId;
import com.neome.api.meta.base.Types.MessageId;
import com.neome.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgMessageReport extends Msg
{
  public ChatId chatId;

  public EntId entId;

  public MessageId messageId;

  public long offset;
}