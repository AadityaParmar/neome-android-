// neome.ai API - do not change
//

package com.neome.java.api.ent.entMain.sig;

import com.neome.java.api.home.drawer.sig.SigUserAvatar;
import com.neome.java.api.meta.base.Types.EntUserId;
import com.neome.java.api.nucleus.base.sig.SigVersion;

import java.util.Map;

@SuppressWarnings("unused")
public class SigEntUserAvatarListGet extends SigVersion
{
  public Map<EntUserId, SigUserAvatar> avatarMap;
}
