// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import com.neome.api.meta.base.Types.EntUserId;
import com.neome.api.meta.base.Types.MetaIdRole;

import org.jetbrains.annotations.Nullable;

import java.util.Set;

@SuppressWarnings("unused")
public class DtoAgentEntUser
{
  public EntUserId entUserId;

  public String handle;

  public String nickName;

  @Nullable
  public Set<MetaIdRole> roleIdSet;

  public String userColor;
}
