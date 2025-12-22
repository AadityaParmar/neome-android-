// neome.ai API - do not change
//

package com.neome.java.api.home.base.dto;

import com.neome.java.api.meta.base.Types.EntUserId;
import com.neome.java.api.meta.base.Types.MediaIdAvatar;

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
