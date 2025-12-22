// neome.ai API - do not change
//

package com.neome.java.api.home.main.msg;

import com.neome.java.api.meta.base.Types.EntUserId;
import com.neome.java.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgChatBlock extends Msg
{
  public boolean block;

  public EntUserId chatId;
}
