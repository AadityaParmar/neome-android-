// neome.ai API - do not change
//

package com.neome.api.ent.entMain.sig;

import com.neome.api.ent.base.dto.DtoEntUserInfo;
import com.neome.api.meta.base.Types.EntUserId;
import com.neome.api.nucleus.base.sig.Sig;

import java.util.Map;

@SuppressWarnings("unused")
public class SigUserActionResult extends Sig
{
  public Map<EntUserId, DtoEntUserInfo> userMap;
}
