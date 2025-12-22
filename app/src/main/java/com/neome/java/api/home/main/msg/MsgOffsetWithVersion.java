// neome.ai API - do not change
//

package com.neome.java.api.home.main.msg;

import com.neome.java.api.core.base.msg.MsgVersion;
import com.neome.java.api.meta.base.Types.ChatId;

@SuppressWarnings("unused")
public class MsgOffsetWithVersion extends MsgVersion
{
  public ChatId chatId;

  public long offset;
}
