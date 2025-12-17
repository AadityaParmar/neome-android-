// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.Types.EntUserId;
import com.neome.api.meta.base.Types.MediaId;
import com.neome.api.meta.base.Types.MetaIdRole;

import java.util.Set;

@SuppressWarnings("unused")
public class DtoEntUserInfo
{
  @Nullable
  public MediaId avatarId;

  public EntUserId entUserId;

  @Nullable
  public String handle;

  @Nullable
  public EntUserId managerId;

  public String nickName;

  @Nullable
  public Set<MetaIdRole> roleIdSet;

  public String userColor;
}
