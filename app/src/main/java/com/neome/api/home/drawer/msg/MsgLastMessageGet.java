// neome.ai API - do not change
//

package com.neome.api.home.drawer.msg;

import com.neome.api.core.base.msg.MsgVersion;
import com.neome.api.meta.base.Types.ContactId;

@SuppressWarnings("unused")
public class MsgLastMessageGet extends MsgVersion
{
  public ContactId chatId;
}
