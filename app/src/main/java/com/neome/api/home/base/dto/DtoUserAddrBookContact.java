// neome.ai API - do not change
//

package com.neome.api.home.base.dto;

import com.neome.api.meta.base.Types.EntUserId;
import com.neome.api.meta.base.Types.MediaIdAvatar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoUserAddrBookContact
{
  public EntUserId entUserId;

  public String handle;

  @Nullable
  public MediaIdAvatar mediaIdAvatar;

  public String nickName;
}
