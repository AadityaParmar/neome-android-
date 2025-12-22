// neome.ai API - do not change
//

package com.neome.java.api.home.aside.msg;

import com.neome.java.api.meta.base.Types.GroupId;
import com.neome.java.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgGroupInviteLink extends Msg
{
  public GroupId groupId;

  @Nullable
  public Boolean reset;
}
