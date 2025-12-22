// neome.ai API - do not change
//

package com.neome.java.api.core.user.msg;

import com.neome.java.api.core.base.msg.MsgHandle;
import com.neome.java.api.meta.base.Types.EnumDeviceType;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgOtpSignIn extends MsgHandle
{
  public String deviceName;

  public EnumDeviceType deviceType;

  @Nullable
  public Boolean rememberMe;
}
