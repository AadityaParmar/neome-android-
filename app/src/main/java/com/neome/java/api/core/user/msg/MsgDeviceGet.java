// neome.ai API - do not change
//

package com.neome.java.api.core.user.msg;

import com.neome.java.api.core.base.msg.MsgVersion;
import com.neome.java.api.meta.base.Types.DeviceId;

@SuppressWarnings("unused")
public class MsgDeviceGet extends MsgVersion
{
  public DeviceId deviceId;
}
