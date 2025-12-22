// neome.ai API - do not change
//

package com.neome.java.api.ent.entMain.sig;

import com.neome.java.api.ent.base.dto.DtoEntUserInfo;
import com.neome.java.api.meta.base.Types.EntUserId;
import com.neome.java.api.nucleus.base.sig.Sig;

import java.util.Map;

@SuppressWarnings("unused")
public class SigUserActionResult extends Sig
{
  public Map<EntUserId, DtoEntUserInfo> userMap;
}
