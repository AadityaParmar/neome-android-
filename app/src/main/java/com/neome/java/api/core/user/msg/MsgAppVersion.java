// neome.ai API - do not change
//

package com.neome.java.api.core.user.msg;

import com.neome.java.api.meta.base.Types.EnumDeviceType;
import com.neome.java.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgAppVersion extends Msg
{
  public EnumDeviceType deviceType;

  public long versionCode;
}
