// neome.ai API - do not change
//

package com.neome.api.core.user.msg;

import com.neome.api.meta.base.Types.EnumDeviceType;
import com.neome.api.meta.base.Types.UserId;
import com.neome.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgSignInUserId extends Msg
{
  public String deviceName;

  public EnumDeviceType deviceType;

  public String password;

  public boolean rememberMe;

  public UserId userId;
}
