// neome.ai API - do not change
//

package com.neome.java.api.home.drawer.sig;

import com.neome.java.api.home.base.dto.DtoChatBadgeMap;
import com.neome.java.api.meta.base.Types.EntId;
import com.neome.java.api.nucleus.base.sig.SigVersion;

import java.util.Map;

@SuppressWarnings("unused")
public class SigBadgeMap extends SigVersion
{
  public Map<EntId, DtoChatBadgeMap> entChatBadgeMap;
}
