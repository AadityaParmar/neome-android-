// neome.ai API - do not change
//

package com.neome.api.home.drawer.msg;

import com.neome.api.meta.base.Types.GroupId;
import com.neome.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgGroupCandidateListGet extends Msg
{
  @Nullable
  public GroupId groupId;
}
