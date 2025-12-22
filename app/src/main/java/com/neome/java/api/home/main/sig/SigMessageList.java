// neome.ai API - do not change
//

package com.neome.java.api.home.main.sig;

import com.neome.java.api.meta.base.Types.ChatId;
import com.neome.java.api.meta.base.Types.EntId;
import com.neome.java.api.nucleus.base.sig.Sig;

@SuppressWarnings("unused")
public class SigMessageList extends Sig
{
  public long bottomOffset;

  public ChatId chatId;

  public String chatIdHash;

  public EntId entId;

  public SigMessage[] messageList;

  public long pageBottomOffset;

  public long pageTopOffset;

  public long readOffset;

  public long topOffset;
}
