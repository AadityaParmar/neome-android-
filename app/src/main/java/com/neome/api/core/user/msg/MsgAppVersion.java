// neome.ai API - do not change
//

package com.neome.api.core.user.msg;

import com.neome.api.meta.base.Types.EnumDeviceType;
import com.neome.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgAppVersion extends Msg
{
  public EnumDeviceType deviceType;

  public long versionCode;
}