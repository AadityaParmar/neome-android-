// neome.ai API - do not change
//

package com.neome.api.home.main.msg;

import com.neome.api.meta.base.Types.ChatId;
import com.neome.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgOffset extends Msg
{
  public ChatId chatId;

  public long offset;
}