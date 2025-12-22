// neome.ai API - do not change
//

package com.neome.java.api.home.aside.msg;

import com.neome.java.api.meta.base.Types.ChatId;
import com.neome.java.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgAsideSearch extends Msg
{
  public ChatId chatId;

  @Nullable
  public Long pageSize;

  public String searchId;

  public String searchQuery;
}
