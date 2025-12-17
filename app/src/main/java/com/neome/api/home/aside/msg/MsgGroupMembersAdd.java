// neome.ai API - do not change
//

package com.neome.api.home.aside.msg;

import com.neome.api.core.base.msg.MsgVersion;
import com.neome.api.meta.base.Types.EntUserId;
import com.neome.api.meta.base.Types.GroupId;

import org.jetbrains.annotations.Nullable;

import java.util.Set;

@SuppressWarnings("unused")
public class MsgGroupMembersAdd extends MsgVersion
{
  public GroupId groupId;

  @Nullable
  public Set<EntUserId> insertAdminSet;

  @Nullable
  public Set<EntUserId> insertMemberSet;
}
