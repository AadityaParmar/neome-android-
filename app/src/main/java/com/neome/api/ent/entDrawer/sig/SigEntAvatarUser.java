// neome.ai API - do not change
//

package com.neome.api.ent.entDrawer.sig;

import com.neome.api.meta.base.Types.EntId;
import com.neome.api.meta.base.Types.MediaIdAvatar;
import com.neome.api.nucleus.base.sig.SigVersion;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class SigEntAvatarUser extends SigVersion
{
  @Nullable
  public String about;

  @Nullable
  public MediaIdAvatar avatarId;

  public EntId entId;

  public String name;
}
