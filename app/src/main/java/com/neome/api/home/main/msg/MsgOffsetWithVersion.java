// neome.ai API - do not change
//

package com.neome.api.home.main.msg;

import com.neome.api.core.base.msg.MsgVersion;
import com.neome.api.meta.base.Types.ChatId;

@SuppressWarnings("unused")
public class MsgOffsetWithVersion extends MsgVersion
{
  public ChatId chatId;

  public long offset;
}
