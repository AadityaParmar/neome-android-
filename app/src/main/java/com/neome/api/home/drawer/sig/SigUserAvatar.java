// neome.ai API - do not change
//

package com.neome.api.home.drawer.sig;

import com.neome.api.meta.base.Types.EntId;
import com.neome.api.meta.base.Types.EntUserId;
import com.neome.api.meta.base.Types.MediaId;
import com.neome.api.nucleus.base.sig.SigVersion;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class SigUserAvatar extends SigVersion
{
  @Nullable
  public String about;

  @Nullable
  public MediaId avatarId;

  public EntId entId;

  public EntUserId entUserId;

  public String firstName;

  @Nullable
  public String handle;

  @Nullable
  public Boolean isBlocked;

  @Nullable
  public Boolean isDeleted;

  public String lastName;

  @Nullable
  public String nickName;

  public String userColor;
}
