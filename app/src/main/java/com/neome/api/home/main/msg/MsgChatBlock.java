// neome.ai API - do not change
//

package com.neome.api.home.main.msg;

import com.neome.api.meta.base.Types.EntUserId;
import com.neome.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgChatBlock extends Msg
{
  public boolean block;

  public EntUserId chatId;
}