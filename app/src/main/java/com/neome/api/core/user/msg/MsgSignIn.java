// neome.ai API - do not change
//

package com.neome.api.core.user.msg;

import com.neome.api.core.base.msg.MsgHandle;
import com.neome.api.meta.base.Types.EnumDeviceType;

@SuppressWarnings("unused")
public class MsgSignIn extends MsgHandle
{
  public String deviceName;

  public EnumDeviceType deviceType;

  public String password;

  public boolean rememberMe;
}
