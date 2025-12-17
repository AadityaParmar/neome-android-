// neome.ai API - do not change
//

package com.neome.api.core.user.msg;

import com.neome.api.meta.base.Types.TabId;
import com.neome.api.nucleus.base.Types.AppVersion;
import com.neome.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgGrantBearerToken extends Msg
{
  public AppVersion appVersion;

  @Nullable
  public Boolean sendCaller;

  public TabId tabId;
}
