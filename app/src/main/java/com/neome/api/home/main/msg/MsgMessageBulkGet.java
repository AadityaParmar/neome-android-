// neome.ai API - do not change
//

package com.neome.api.home.main.msg;

import com.neome.api.meta.base.Types.ChatId;
import com.neome.api.nucleus.base.msg.Msg;

import java.util.Map;

@SuppressWarnings("unused")
public class MsgMessageBulkGet extends Msg
{
  public ChatId chatId;

  public Map<Long, String> offsetMap;
}
