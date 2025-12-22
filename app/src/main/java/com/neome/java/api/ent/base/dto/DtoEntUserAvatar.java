// neome.ai API - do not change
//

package com.neome.java.api.ent.base.dto;

import com.neome.java.api.meta.base.Types.EntUserId;
import com.neome.java.api.meta.base.Types.MediaId;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoEntUserAvatar
{
  @Nullable
  public MediaId avatarId;

  public EntUserId entUserId;

  public String handle;

  public String nickName;
}
