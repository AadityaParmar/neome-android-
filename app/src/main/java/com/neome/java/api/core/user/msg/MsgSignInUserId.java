// neome.ai API - do not change
//

package com.neome.java.api.core.user.msg;

import com.neome.java.api.meta.base.Types.EnumDeviceType;
import com.neome.java.api.meta.base.Types.UserId;
import com.neome.java.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgSignInUserId extends Msg
{
  public String deviceName;

  public EnumDeviceType deviceType;

  public String password;

  public boolean rememberMe;

  public UserId userId;
}
