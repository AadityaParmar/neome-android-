// neome.ai API - do not change
//

package com.neome.api.ent.agent.sig;

import com.neome.api.ent.base.dto.DtoAgentEntUser;
import com.neome.api.meta.base.Types.EntUserId;
import com.neome.api.nucleus.base.sig.SigVersion;

import java.util.Map;

@SuppressWarnings("unused")
public class SigAgentEntUserList extends SigVersion
{
  public Map<EntUserId, DtoAgentEntUser> entUserMap;
}
