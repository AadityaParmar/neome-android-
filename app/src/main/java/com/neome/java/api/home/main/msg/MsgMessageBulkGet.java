// neome.ai API - do not change
//

package com.neome.java.api.home.main.msg;

import com.neome.java.api.meta.base.Types.ChatId;
import com.neome.java.api.nucleus.base.msg.Msg;

import java.util.Map;

@SuppressWarnings("unused")
public class MsgMessageBulkGet extends Msg
{
  public ChatId chatId;

  public Map<Long, String> offsetMap;
}
