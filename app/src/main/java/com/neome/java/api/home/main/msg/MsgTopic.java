// neome.ai API - do not change
//

package com.neome.java.api.home.main.msg;

import com.neome.java.api.core.base.Types.EnumTopicType;
import com.neome.java.api.meta.base.SysId;
import com.neome.java.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgTopic extends Msg
{
  public SysId aboutId;

  public EnumTopicType type;
}
