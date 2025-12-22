// neome.ai API - do not change
//

package com.neome.java.api.core.deeplink.msg;

import com.neome.java.api.meta.base.Types.EnumDeviceType;
import com.neome.java.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgDeeplinkCode extends Msg
{
  public String deeplinkCode;

  @Nullable
  public String deviceName;

  @Nullable
  public EnumDeviceType deviceType;
}
