// neome.ai API - do not change
//

package com.neome.java.api.home.drawer.msg;

import com.neome.java.api.meta.base.Types.EntUserId;
import com.neome.java.api.nucleus.base.msg.Msg;

import java.util.Map;

@SuppressWarnings("unused")
public class MsgUserAvatarBulkGet extends Msg
{
  public Map<EntUserId, String> userIdVersionMap;
}
