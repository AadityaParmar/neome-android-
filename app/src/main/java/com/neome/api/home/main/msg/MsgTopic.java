// neome.ai API - do not change
//

package com.neome.api.home.main.msg;

import com.neome.api.core.base.Types.EnumTopicType;
import com.neome.api.meta.base.SysId;
import com.neome.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgTopic extends Msg
{
  public SysId aboutId;

  public EnumTopicType type;
}
