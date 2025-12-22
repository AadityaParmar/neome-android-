// neome.ai API - do not change
//

package com.neome.java.api.home.drawer.msg;

import com.neome.java.api.meta.base.Types.GroupId;
import com.neome.java.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgGroupCandidateListGet extends Msg
{
  @Nullable
  public GroupId groupId;
}
