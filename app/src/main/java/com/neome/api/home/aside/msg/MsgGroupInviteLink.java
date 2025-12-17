// neome.ai API - do not change
//

package com.neome.api.home.aside.msg;

import com.neome.api.meta.base.Types.GroupId;
import com.neome.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgGroupInviteLink extends Msg
{
  public GroupId groupId;

  @Nullable
  public Boolean reset;
}
