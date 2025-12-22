// neome.ai API - do not change
//

package com.neome.java.api.ent.agent.sig;

import com.neome.java.api.ent.base.dto.DtoAgentEntUser;
import com.neome.java.api.meta.base.Types.EntUserId;
import com.neome.java.api.nucleus.base.sig.SigVersion;

import java.util.Map;

@SuppressWarnings("unused")
public class SigAgentEntUserList extends SigVersion
{
  public Map<EntUserId, DtoAgentEntUser> entUserMap;
}
