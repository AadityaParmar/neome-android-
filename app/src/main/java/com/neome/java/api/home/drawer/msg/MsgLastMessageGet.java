// neome.ai API - do not change
//

package com.neome.java.api.home.drawer.msg;

import com.neome.java.api.core.base.msg.MsgVersion;
import com.neome.java.api.meta.base.Types.ContactId;

@SuppressWarnings("unused")
public class MsgLastMessageGet extends MsgVersion
{
  public ContactId chatId;
}
