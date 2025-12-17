// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.Types.EntUserId;
import com.neome.api.meta.base.Types.MediaId;

@SuppressWarnings("unused")
public class DtoEntUserAvatar
{
  @Nullable
  public MediaId avatarId;

  public EntUserId entUserId;

  public String handle;

  public String nickName;
}
