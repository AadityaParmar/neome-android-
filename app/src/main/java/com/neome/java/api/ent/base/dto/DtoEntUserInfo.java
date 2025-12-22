// neome.ai API - do not change
//

package com.neome.java.api.ent.base.dto;

import com.neome.java.api.meta.base.Types.EntUserId;
import com.neome.java.api.meta.base.Types.MediaId;
import com.neome.java.api.meta.base.Types.MetaIdRole;

import org.jetbrains.annotations.Nullable;

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
