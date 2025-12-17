// neome.ai API - do not change
//

package com.neome.api.core.user.msg;

import com.neome.api.core.base.msg.MsgVersion;
import com.neome.api.meta.base.Types.DeviceId;

@SuppressWarnings("unused")
public class MsgDeviceGet extends MsgVersion
{
  public DeviceId deviceId;
}
