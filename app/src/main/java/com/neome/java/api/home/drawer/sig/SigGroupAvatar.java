// neome.ai API - do not change
//

package com.neome.java.api.home.drawer.sig;

import com.neome.java.api.meta.base.Types.EntId;
import com.neome.java.api.meta.base.Types.GroupId;
import com.neome.java.api.meta.base.Types.MediaIdAvatar;
import com.neome.java.api.nucleus.base.sig.SigVersion;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class SigGroupAvatar extends SigVersion
{
  @Nullable
  public String about;

  @Nullable
  public MediaIdAvatar avatarId;

  public EntId entId;

  public GroupId groupId;

  @Nullable
  public Boolean isAdmin;

  public boolean isMember;

  @Nullable
  public String label;

  public String name;
}
