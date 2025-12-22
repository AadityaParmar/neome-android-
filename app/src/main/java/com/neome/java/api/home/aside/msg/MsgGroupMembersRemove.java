// neome.ai API - do not change
//

package com.neome.java.api.home.aside.msg;

import com.neome.java.api.core.base.msg.MsgVersion;
import com.neome.java.api.meta.base.Types.EntUserId;
import com.neome.java.api.meta.base.Types.GroupId;

import org.jetbrains.annotations.Nullable;

import java.util.Set;

@SuppressWarnings("unused")
public class MsgGroupMembersRemove extends MsgVersion
{
  public GroupId groupId;

  @Nullable
  public Set<EntUserId> removeAdminSet;

  @Nullable
  public Set<EntUserId> removeMemberSet;
}
