// neome.ai API - do not change
//

package com.neome.api.ent.entMain.sig;

import com.neome.api.home.drawer.sig.SigUserAvatar;
import com.neome.api.meta.base.Types.EntUserId;
import com.neome.api.nucleus.base.sig.SigVersion;

import java.util.Map;

@SuppressWarnings("unused")
public class SigEntUserAvatarListGet extends SigVersion
{
  public Map<EntUserId, SigUserAvatar> avatarMap;
}
