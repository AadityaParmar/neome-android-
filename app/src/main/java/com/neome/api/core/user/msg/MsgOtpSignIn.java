// neome.ai API - do not change
//

package com.neome.api.core.user.msg;

import com.neome.api.core.base.msg.MsgHandle;
import com.neome.api.meta.base.Types.EnumDeviceType;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgOtpSignIn extends MsgHandle
{
  public String deviceName;

  public EnumDeviceType deviceType;

  @Nullable
  public Boolean rememberMe;
}
